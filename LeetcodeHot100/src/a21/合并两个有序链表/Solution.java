package a21.合并两个有序链表;

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode head=new ListNode(),cur=head;
        while (list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                cur.next=list1;
                cur=cur.next;
                list1=list1.next;
            }else {
                cur.next=list2;
                cur=cur.next;
                list2=list2.next;
            }
        }
        if(list1!=null)cur.next=list1;
        if(list2!=null)cur.next=list2;
        return head.next;
    }
}