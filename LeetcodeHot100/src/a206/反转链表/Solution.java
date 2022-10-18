package a206.反转链表;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head!=null&&head.next==null)return head;
        if(head.next.next==null){
            // 只有两个结点
            ListNode second=head.next;
            second.next=head;
            head.next=null;
            return second;
        }
        ListNode n1=head,n2=head.next,n3=head.next.next;
        n1.next=null;
        while (true){
            n2.next=n1;
            n1=n2;
            n2=n3;
            if(n2==null)break;
            n3=n3.next;
        }
        return n1;
    }
}