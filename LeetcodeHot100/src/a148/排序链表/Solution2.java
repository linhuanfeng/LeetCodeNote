package a148.排序链表;

/**
 * 归并排序（递归）:
 * 时间：归并是nlogn
 * 空间：递归栈 logn
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        // 快慢指针找到中间结点
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp=slow.next;
        slow.next=null; // 分割两半
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        // 合并：将两个各自有序的分区合并
        ListNode h = new ListNode();
        ListNode res=h;
        while (left!=null&&right!=null){
            if(left.val<= right.val){ // =号保证稳定排序
                h.next=left;
                left=left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        h.next=left!=null?left:right; // 剩下结点直接拼接
        return res.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        node4.next=node2;
        node2.next=node1;
        node1.next=node3;
        ListNode head = solution.sortList(node4);
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}