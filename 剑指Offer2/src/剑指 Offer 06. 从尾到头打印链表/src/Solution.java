import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 时间复杂度：O(n)O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
 * 空间复杂度：O(n)O(n)。额外使用一个栈存储链表中的每个节点。
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack=new LinkedList();
        ListNode p=head;
        while (p!=null){
            stack.push(p.val);  //这里会自动装箱
            p=p.next;
        }
        int[] arr=new int[stack.size()];
        int i=0;
        for (Integer integer : stack) {
            arr[i++]=integer;
        }
        return arr;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }