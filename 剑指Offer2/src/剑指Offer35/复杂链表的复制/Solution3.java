package 剑指Offer35.复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归创建+哈希表Map<Node1,Node2>
 * <p>
 * node1为旧结点，node2为新节点，递归创建
 * if(!map.contains(node1)){
 *  Node Node2= new Node(node1.val)
 *  map.put(node1,Node2);
 *  node2.next=copy(node1.next);
 *  node2.random=copy(node1.random);
 * }
 * return map.get(node1);
 * <p>
 * 时间：O(n) 一次遍历
 * 空间：O(n) 哈希表的开销
 */
public class Solution3 {
    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node node2 = new Node(head.val);
            map.put(head, node2);
            node2.next = copyRandomList(head.next);
            node2.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.random = node;
        Node newHead = new Solution3().copyRandomList(node);
        while (newHead != null) {
            System.out.println(newHead.val + ":" + ((newHead.random != null) ? (newHead.random.val) : "null"));
            newHead = newHead.next;
        }
    }
}
