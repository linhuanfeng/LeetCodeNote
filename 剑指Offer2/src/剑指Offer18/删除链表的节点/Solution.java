package 剑指Offer18.删除链表的节点;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val){
            return head.next;
        }
        ListNode node=head;
        while (node.next.val!=val){
            node=node.next;
        }
        node.next=node.next.next;
        return head;
    }
}
