package 代码阅读.链表反转;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode modifyList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode tempNode = head.next;
        head.next = null;
        while (tempNode != null) {
            head = tempNode;
            tempNode = tempNode.next;
            head.next = node;
            node = head;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode head = ListNode.modifyList(node1);
        // 原地反转链表
        while (head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
}
