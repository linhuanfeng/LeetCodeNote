package 链表节点的异或;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * 1 0 1 1
 * 0 1
 *
 * 1 0
 *
 */
// 死循环 0
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    ListNode head;
    public ListNode xorList(ListNode a, ListNode b) {
        // write code here
        if(a.next!=null){
            ListNode node = xorList(a.next, b);
            node.next=head;
            head=node;
        }else {
            ListNode node = new ListNode(a.val ^ (b == null ? 0 : b.val));
            node.next=head;
            head=node;
            if(b!=null){
                b=b.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);

        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(1);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node5.next=node6;

        ListNode list = new Solution().xorList(node1, node5);
        while (list!=null){
            System.out.print(list.val+" ");
            list=list.next;
        }
    }
}