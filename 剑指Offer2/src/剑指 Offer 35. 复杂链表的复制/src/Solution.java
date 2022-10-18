import java.util.HashMap;

public class Solution {
    HashMap<Node,Node> map=new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        if(!map.containsKey(head)){
            Node node=new Node(head.val);
            map.put(head,node);
            // 当前节点的下一个节点或者随机节点未被创建，则递归的创建
            node.next=copyRandomList(head.next);
            node.random=copyRandomList(head.random);
        }
        return map.get(head);
    }

}
