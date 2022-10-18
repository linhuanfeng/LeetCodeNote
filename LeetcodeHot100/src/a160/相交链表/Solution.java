package a160.相交链表;

/**
 * 双指针最后相交于交点，因为走的路程是一样的
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;
        boolean changeA=true,changeB=true; // 标记一次转换
        while (A!=null&&B!=null&&A!=B){
            A=A.next;
            B=B.next;
            if(A==null&&changeA){
                A=headB;
                changeA=false;
            }
            if(B==null&&changeB){
                B=headA;
                changeB=false;
            }
        }
        return A==B?A:null;
    }
}