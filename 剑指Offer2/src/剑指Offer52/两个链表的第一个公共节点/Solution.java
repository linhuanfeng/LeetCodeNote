package 剑指Offer52.两个链表的第一个公共节点;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

/**
 * 双指针
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;
        boolean changeA=false,changeB=false;
        while (A!=null&&B!=null){
            if(A==B){
                return A;
            }
            if(null==A.next&&!changeA){ //到尾部了,并且还没换过链表遍历
                A=headB;
                changeA=true;
            }else {
                A=A.next;
            }
            if(null==B.next&&!changeB){ //到尾部了,并且还没换过链表遍历
                B=headA;
                changeB=true;
            }else {
                B=B.next;
            }
        }
        return null;
    }
}