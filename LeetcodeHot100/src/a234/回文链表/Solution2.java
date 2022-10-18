package a234.回文链表;

/**
 * 对链表另一半进行翻转，再逐个比较
 * 使用快慢指针确定链表中间位置,并利用慢指针将链表分为两半
 *
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if(head.next==null)
            return true;
        ListNode slow=head,quick=head.next;
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        // 后半链表进行翻转
        ListNode prev=null,node=slow.next,next=node.next;
        slow.next=null;// 断开
        while (next!=null){ // 翻转链表
            node.next=prev;
            prev=node;
            node=next;
            next=next.next;
        }
        node.next=prev;
        // 链表比较
        ListNode node1=head,node2=node;
        while (node1!=null&&node2!=null){ // 奇数情况下，node2提前为null退出循环，也是满足回文数的
            if(node1.val!= node2.val)
                return false;
            node1=node1.next;
            node2=node2.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        System.out.println(solution.isPalindrome(node1));
    }
}