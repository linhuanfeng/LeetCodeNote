package a160.相交链表;

/**
 * 双指针最后相交于交点，或者最后都等于null,因为走的路程是一样的
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;
        while (A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A; // A==b相交，或者不相交A=B=null
    }
}