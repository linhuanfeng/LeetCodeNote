package JUC.阻塞队列;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> implements BlockingQueue {
    private final int capacity = 10000;
    private final AtomicInteger count = new AtomicInteger(0);
    private Node head;
    private Node last;
    private final ReentrantLock takeLock =new ReentrantLock(); // take锁
    private final Condition notEmpty = takeLock.newCondition(); // 非空条件
    private final ReentrantLock putLock =new ReentrantLock();
    private final Condition notFull = putLock.newCondition();

    public MyBlockingQueue() {
        last = head = new Node(null);
    }

    public void put(Object e) throws InterruptedException {
        if (e == null) throw new NullPointerException();
        int c = -1;
        Node node = new Node(e);
        final ReentrantLock putLock = this.putLock;
        final AtomicInteger count = this.count;
        putLock.lockInterruptibly(); // 入队加锁
        try {
            while (count.get() == capacity) {
                notFull.await(); // 如果满了阻塞
            }
            enqueue(node);
            c = count.getAndIncrement(); // 原子加一并返回原值
            if (c + 1 < capacity)
                notFull.signal();
        } finally {
            putLock.unlock();
        }
        if (c == 0) // c=0表示原来为空，现在插入后不为空了，通知take取消阻塞。如果c!=0说明原来队列有值，那么对应取状态没阻塞，不用通知
            signalNotEmpty();
    }

    public Object take() throws InterruptedException {
        Object x;
        int c = -1;
        final AtomicInteger count = this.count;
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lockInterruptibly();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
        if (c == capacity)
            signalNotFull();
        return x;
    }

    private void enqueue(Node node) {
        last = last.next = node;
    }

    private Object dequeue() {
        Node h = head;
        Node first = h.next;
        h.next = h; // help GC
        head = first;
        Object x = first.item;
        first.item = null;
        return x;
    }

    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        takeLock.lock();
        try {
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        putLock.lock();
        try {
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    static class Node {
//        E item;
        Object item;
        Node next;

        Node(Object x) {
            item = x;
        }
    }
}