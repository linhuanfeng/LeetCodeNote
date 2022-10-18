package a234.回文链表;

/**
 * 使用递归的方式,利用递归反向迭代进行比较
 *
 * 时间：O(n):链表的长度
 * 空间：O(n)：栈的深度
 */
class Solution3 {
    public boolean isPalindrome(ListNode head) {
        frontNode=head;
        return recursive(head);
    }
    private ListNode frontNode;
    private boolean recursive(ListNode curNode){
        if(curNode!=null){
            if(!recursive(curNode.next)){
                return false;
            }
            if(curNode.val!= frontNode.val){ // 走到这一步的时候curNode是最后一个元素，frontNode还是第一个元素
                return false;
            }
            frontNode=frontNode.next; // frontNode右移，同时回溯的时候curNode相当于往前移
        }
        return true;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        System.out.println(solution.isPalindrome(node1));
    }
}