package JUC.JUC代码.lock.线程交替打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替打印ABC,基于condition实现
 */
public class ConditionTest {
    public static void main(String[] args) {
        InterPrint interPrint = new InterPrint();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                interPrint.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                interPrint.printB();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                interPrint.printC();
            }
        }).start();
    }
}

class InterPrint {
    Lock lock;
    int num = 1; // 1就打印A
    Condition conditionA;
    Condition conditionB;
    Condition conditionC;

    public InterPrint() {
        lock = new ReentrantLock();
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
        conditionC = lock.newCondition();
    }

    void printA() {
        try {
            lock.lock();
            while (num != 1) {
                conditionA.await();
            }
            System.out.println("A...");
            num=2;
            conditionB.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void printB() {
        try {
            lock.lock();
            while (num != 2) {
                conditionB.await();
            }
            System.out.println("B...");
            num=3;
            conditionC.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        try {
            lock.lock();
            while (num != 3) {
                conditionC.await();
            }
            System.out.println("C...");
            num=1;
            conditionA.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
