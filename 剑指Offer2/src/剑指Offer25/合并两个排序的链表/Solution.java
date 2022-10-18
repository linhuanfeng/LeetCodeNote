package 剑指Offer25.合并两个排序的链表;

import com.sun.org.apache.bcel.internal.generic.LNEG;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode root=new ListNode(0);
//        ListNode p=root;
//        while (l1!=null&&l2!=null){
//            if(l1.val>l2.val){
//                p.next=new ListNode(l2.val);
//                p=p.next;
//                l2=l2.next;
//            }else {
//                p.next=new ListNode(l1.val);
//                p=p.next;
//                l1=l1.next;
//            }
//        }
//        if(l1!=null){
//            do{
//                p.next=new ListNode(l1.val);
//                p=p.next;
//                l1=l1.next;
//            }while (l1!=null);
//        }
//        if(l2!=null){
//            do{
//                p.next=new ListNode(l2.val);
//                p=p.next;
//                l2=l2.next;
//            }while (l2!=null);
//        }
//        return root.next;
//    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root=new ListNode(0);
        ListNode p=root;
        while (l1!=null&&l2!=null){
            if(l1.val>l2.val){
                p.next=l2;
                p=p.next;
                l2=l2.next;
            }else {
                p.next=l1;
                p=p.next;
                l1=l1.next;
            }
        }
        p.next=l1!=null?l1:l2;
        return root.next;
    }
}
