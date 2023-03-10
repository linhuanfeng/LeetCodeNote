package 剑指Offer35.复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 用Map存下标和对应的结点，方便O(1)获取目标结点
 * [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 遍历原链表得出->结点对应的位置下标NodeToIndex<Node,index>
 * 然后也能知道random指针对应的结点下标
 *
 * 再遍历原链表得出->构建新链表下标对应的结点IndexToNode<index,newNode>
 *
 * 勉强通过，考虑递归
 *
 * 时间：O(n)
 * 空间：O(n) map存新建的结点
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 结点对应的下标
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Node p=head;
        int i=0;
        while (p!=null){
            nodeToIndex.put(p,i++);
            p=p.next;
        }
        // 新链表下标对应的结点
        Map<Integer, Node> indexToNode = new HashMap<>();
        p=head;
        i = 0;
        while (p != null) {
            Node nodeCur = indexToNode.getOrDefault(i, new Node(p.val));
            indexToNode.put(i,nodeCur);
            if(p.random!=null){
                // 随机结点的下标
                int random_index=nodeToIndex.get(p.random);
                Node nodeRandom = indexToNode.getOrDefault(random_index, new Node(p.random.val));
                // 随机结点存入map
                indexToNode.put(random_index,nodeRandom);
                nodeCur.random=nodeRandom;
            }
            if(p.next!=null){
                Node nodeNext = indexToNode.getOrDefault(i+1, new Node(p.next.val));
                indexToNode.put(i+1,nodeNext);
                nodeCur.next=nodeNext;
            }
            i++;
            p=p.next;
        }
        return indexToNode.get(0);
    }

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.random=node;
        Node newHead = new Solution2().copyRandomList(node);
        while (newHead!=null){
            System.out.println(newHead.val+":"+((newHead.random!=null)?(newHead.random.val):"null"));
            newHead=newHead.next;
        }
    }
}
