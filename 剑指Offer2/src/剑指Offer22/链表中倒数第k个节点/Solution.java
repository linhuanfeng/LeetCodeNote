package 剑指Offer22.链表中倒数第k个节点;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int[] vis =new int[k];
        ListNode res=head;
        for (int i = 0; i < k; i++) {
            head=head.next;
        }
        while (head!=null){
            head=head.next;
            res=res.next;
        }
        return res;
    }
}
