package a148.排序链表;

/**
 * 普通冒泡排序，超时
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre_head = new ListNode(),a,b;
        pre_head.next=head;
        a=pre_head;
        b=pre_head.next;
        int count=0;
        while (b!=null){
            count++;
            b=b.next;
        }
        b=head;
        for (int i = 0; i < count-1; i++) {
            while (b.next!=null){
                if(b.val>b.next.val){
                    swap(a,b,b.next);
                }
                a=a.next;
                b=a.next;
            }
            a=pre_head;
            b=pre_head.next;
        }
        return pre_head.next;
    }

    private void swap(ListNode a, ListNode b, ListNode c) {
        a.next=b.next;
        b.next=c.next;
        a.next.next=b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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