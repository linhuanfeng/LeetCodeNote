package 剑指Offer52.两个链表的第一个公共节点;


/**
 * 双指针
 *  指针A先从表A开始，再从表B开始
 *  指针B先从表B开始，再从表A开始
 *
 * 设表A的长度是a,表B的长度是b,公共部分的长度是c
 * 若
 *  有共同节点,一定会相交，因为a+b-c=b+a-c
 *  没有公共节点，最后都指向null
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA,B=headB;
        while (A!=B){
            // 我这样死循环了，A需要设为null最终才会循环结束
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
}