package a206.反转链表;

/**
 * 递归法
 *
 * p1 p2 p3 p4 p5 p6
 *             h
 *
 * h.next.next=h;
 * h.next=null; // 置空，不然死循环
 *
 * <p>
 * 时间：O（n）
 * 空间：O(n) 递归深度
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next=head;
        head.next=null; // 置空，不然死循环

        return newHead;
    }
}