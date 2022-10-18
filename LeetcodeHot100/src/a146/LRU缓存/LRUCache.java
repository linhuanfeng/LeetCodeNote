package a146.LRU缓存;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用hashMap+双向链表
 * 算法思想：
 * 插入操作：
 * 判断map里面有没有，有直接返回，并定位到双向链表的位置移到头部
 * 没有，放入map中，并添加到链表首部（如果超过容量，删除链表尾结点）
 * 获取操作：
 * 判断map里面有没有，有直接返回，对于链表结点移到头部
 * 没有，返回-1
 */
class LRUCache {

    private Map<Integer, Node> map = new HashMap();
    private int capacity;

    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    private void moveToHead(Node node){
        if (node == head) {
            // 当前的头节点，那么不用再移动
        } else {
            // 断开结点
            node.prev.next = node.next;
            if (node != tail) {
                node.next.prev = node.prev;
            }else {
                tail=tail.prev;
            }
            // 移到首部
            head.prev = node;
            node.next = head;
            node.prev=null;
            head = node;
        }
    }

    private void addFirst(Node newNode){
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            if (map.size() > capacity) {
                tail.prev.next = null;
                map.remove(tail.key); // 删除缓存
                tail = tail.prev;
            }
        }
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            // 缓存没有
            return -1;
        } else {
            // 对应结点移到队头
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if (node == null) {
            // 不存在，加入缓存
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            // 插入链表头部
            addFirst(newNode);
        } else {
            // 已存在，替换新值
            node.val = value;
            // 移到链表头部
            moveToHead(node);
        }
    }
}

// 双侠给链表
class Node {
    public Node prev;
    public Node next;
    public Integer key;
    public Integer val;

    public Node(Integer key,Integer val) {
        this.key=key;
        this.val = val;
    }
}