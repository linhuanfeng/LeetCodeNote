package 链表节点的异或;
// 26
public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a ListNode类
     * @param b ListNode类
     * @return ListNode类
     */
    public ListNode xorList(ListNode a, ListNode b) {
        // write code here
        ListNode a2 = trans(a);
        ListNode head=null;
        while (a2 != null || b != null) {
            ListNode node = new ListNode((a2 == null ? 0 : a2.val)^ (b == null ? 0 : b.val));
            node.next = head;
            head = node;
            if(a2!=null){
                a2=a2.next;
            }
            if (b != null) {
                b = b.next;
            }
        }
        while (head!=null&&head.val==0){
            head=head.next;
        }
        return head;
    }

    ListNode trans(ListNode head) {
        ListNode p1 = null;
        while (head != null) {
            ListNode p2 = head.next;
            head.next = p1;
            p1 = head;
            head = p2;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);

        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;

        ListNode list = new Solution2().xorList(node1, node5);
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}