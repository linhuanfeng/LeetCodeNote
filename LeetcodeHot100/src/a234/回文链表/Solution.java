package a234.回文链表;

import java.util.Deque;
import java.util.LinkedList;

//
class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> stack=new LinkedList<>();
        stack.addLast(head.val);
        ListNode prev=null,node=head,next=node.next;
        while (next!=null){ // 翻转链表
            node.next=prev;
            prev=node;
            node=next;
            next=next.next;
            stack.addLast(node.val);
        }
        node.next=prev;
        for (int i = stack.size()/2; i >0 ; i--) {
            if(node.val!=stack.removeFirst())
                return false;
            node=node.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next=node2;
        System.out.println(solution.isPalindrome(node1));
    }
}