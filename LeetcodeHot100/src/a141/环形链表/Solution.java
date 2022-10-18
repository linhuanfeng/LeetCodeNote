package a141.环形链表;

/**
 * 龟兔赛跑，快慢指针
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)return false;
        ListNode quick=head.next,slow=head;
        while (quick!=null&&slow!=null){
            if(quick==slow)return true;
            quick=quick.next;
            slow=slow.next;
            if(quick!=null)
                quick=quick.next;
        }
        return false;
    }
}