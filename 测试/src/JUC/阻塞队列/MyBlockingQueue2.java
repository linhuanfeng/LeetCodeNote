package JUC.阻塞队列;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue2 implements BlockingQueue {
    private int capacity = 5;
    // 队列大小原子类
    private AtomicInteger count = new AtomicInteger(0);

    // 添加元素互斥锁
    private ReentrantLock putLock = new ReentrantLock();
    // 队列不满条件，满了就得阻塞
    private Condition notFull = putLock.newCondition();

    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notEmpty = takeLock.newCondition();

    private Node head, tail;

    @Override
    public void put(Object item) {
        putLock.lock();
        final AtomicInteger count = this.count;
        int c = -1;
        try {
            while (count.get() == capacity) {
                notFull.await();
            }
            enqueue(item);
            System.out.println(count.get() + 1);
            c = count.getAndIncrement();
//            if (c + 1 < capacity) {
//                notFull.signal();
//            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            putLock.unlock();
        }
        if (c == 0) {
            // 第一次有数据，通知take取消等待
            signalNotEmpty();
        }
    }

    @Override
    public Integer take() {
        final ReentrantLock takeLock = this.takeLock;
        final AtomicInteger count = this.count;
        int c=-1;
        try {
            takeLock.lock();
            while (count.get() == 0) {
                notEmpty.await();
            }
            dequeue();
            System.out.println(count.get());
            c=count.getAndDecrement();
//            if (c == capacity) {
//                notEmpty.signal(); // 队列还有元素则通知可以继续取
//            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            takeLock.unlock();
        }
        if(c==capacity)
            signalNotFull(); // 原来是满的，现在不满了，通知可以put
        return null;
    }

    private void signalNotEmpty() {
        final ReentrantLock takeLock = this.takeLock;
        try {
            takeLock.lock();
            notEmpty.signal();
        } finally {
            takeLock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock putLock = this.putLock;
        try {
            putLock.lock();
            notFull.signal();
        } finally {
            putLock.unlock();
        }
    }

    private void enqueue(Object item) {
        if (head == null) {
            tail = head = new Node(item);
        } else {
            tail = tail.next = new Node(item);
        }
    }

    private Object dequeue() {
        if (head == null)
            throw new IllegalStateException("出队时head不能为null");
        Node h = head;
        head = head.next;
        h.next = null;
        if (count.get() <= 1)
            tail = head;
        return h;
    }

    class Node {
        Object item;
        Node next;

        public Node(Object item) {
            this.item = item;
        }
    }
}
