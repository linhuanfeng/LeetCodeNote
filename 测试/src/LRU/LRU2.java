package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU2 {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int cacheSize = 0;
    Node head, tail;
    Map<Integer, Node> map = new HashMap<>();

    public LRU2(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    private void moveToHead(Node node) {
        if (head == node) {
            // 只有当前结点，不用移动
        } else {
            // 至少有两个结点，所以不用担心tail.prev=null
            // 断开结点
            if (tail == node) { // 当前结点node是尾节点
                tail = tail.prev;
//                tail.next = null; 不需要，因为当前结点后面会进行操作，只需要保证前后结点断开即可
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            // 移到队头
            addFirst(node);
        }
    }

    private void addFirst(Node node) {
        if(head!=null) {
            head.prev = node;
            node.next = head;
            head = node;
        }else {
            head=tail=node;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            // 第一次添加
            node = new Node(key, value);
            map.put(key, node);
            addFirst(node);
            if(map.size()>cacheSize){
                map.remove(tail.key);
                tail=tail.prev;
                tail.next=null;
            }
        }else {
            node.value=value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRU2 lru = new LRU2(3);
        lru.put(1, 1);
        lru.put(2, 1);
        lru.put(3, 1);
        lru.put(4, 1);
        System.out.println(lru.get(1));
//        System.out.println("是否包含最老的1:"+lru.containsKey("1")+",size="+lru.size());
//        for (Map.Entry<String, String> entry : lru.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        } // 2,3,4
//        lru.get("3");
//        System.out.println("=====新访问的元素会移到队尾======");
//        for (Map.Entry<String, String> entry : lru.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        } // 2,4,3
    }
}
