package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU3 {
    class Node {
        Node prev;
        Node next;
        int key, value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node head, tail;

    public LRU3(int capacity) {
        this.capacity = capacity;
    }

    void deleteNode(Node node) {
        // 删除结点
        node.prev.next = node.next;
        if (node.next == null) {
            // 队尾的话tail指针要往前移
            tail = tail.prev;
        } else {
            node.next.prev = node.prev;
        }
    }

    void addHead(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            // 添加到队头
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            if (head != node) {
                // 说明至少有两个元素
                deleteNode(node);
                addHead(node);
            }
            return node.value;
        }
    }

    void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // 更新结点，移到队头
            node.value = value;
            deleteNode(node);
            addHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            addHead(node);
            // 新增结点后，考虑是否容量不够
            if (map.size() > capacity) {
                map.remove(tail.key);
                deleteNode(tail);
            }
        }
    }

    public static void main(String[] args) {
        LRU3 lru = new LRU3(3);
        lru.put(1, 1);
        lru.put(2, 1);
        lru.put(3, 1);
        lru.put(4, 1);
        lru.put(5, 1);
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(2)); // -1
        System.out.println(lru.get(3)); // 1
    }
}
