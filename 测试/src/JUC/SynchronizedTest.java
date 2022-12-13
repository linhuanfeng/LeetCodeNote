package JUC;

import java.io.IOException;

/**
 * synchronized:静态方法锁的是Class对象,非静态方法锁的是this对象。
 */
public class SynchronizedTest {
    volatile static boolean flag = false;

    public synchronized void syncA() {
        System.out.println("syncA:" + Thread.currentThread().getName());
        while (!flag) ; // 空转，保证持有锁
    }

    public synchronized void syncB() {
        System.out.println("syncB:" + Thread.currentThread().getName());
    }

    public void syncA2() {
        synchronized (new Object()) {
            System.out.println("syncA:" + Thread.currentThread().getName());
            while (!flag) ; // 空转，保证持有锁
        }
    }

    public synchronized void syncB2() {
        synchronized (new Object()) {
            System.out.println("syncB:" + Thread.currentThread().getName());
        }
    }

    public static synchronized void sSyncA() {
        System.out.println("static SyncA:" + Thread.currentThread().getName());
        while (!flag) ; // 空转，保证持有锁
    }

    public static synchronized void sSyncB() {
        System.out.println("static SyncB:" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        // sSyncA和sSyncA是同个Class锁
//        new Thread(() -> {
//            SynchronizedTest.sSyncA();
//        }, "线程A").start();
//        new Thread(() -> {
//            SynchronizedTest.sSyncB(); // 会阻塞，因为static修饰的是同个Class对象
//        }, "线程B").start();
//        try {
//            System.out.println("输入回车，让线程A释放锁");
//            System.in.read();
//            flag=true;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        // syncA和syncB是同个对象锁，会相互阻塞
//        SynchronizedTest test = new SynchronizedTest();
//        new Thread(() -> {
//            test.syncA();
//        }, "线程A").start();
//        new Thread(() -> {
//            test.syncB(); // 会阻塞，因为是同个对象test
//        }, "线程B").start();
//        try {
//            System.out.println("输入回车，让线程A释放锁");
//            System.in.read();
//            flag = true;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // syncA和syncB是同个对象锁，会相互阻塞
        SynchronizedTest test = new SynchronizedTest();
        new Thread(() -> {
            test.syncA2();
        }, "线程A").start();
        new Thread(() -> {
            test.syncB2(); // 不会阻塞，因为是不同代码块锁的不同对象
        }, "线程B").start();
        try {
            System.out.println("输入回车，让线程A释放锁");
            System.in.read();
            flag = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // syncA和sSyncA不是锁
//        SynchronizedTest test = new SynchronizedTest();
//        new Thread(() -> {
//            test.syncA();
//        }, "线程A").start();
//        new Thread(() -> {
//            SynchronizedTest.sSyncA(); // 不同锁不会阻塞，一个是对象锁，一个Class锁
//        }, "线程B").start();
//        try {
//            System.out.println("输入回车，让线程A释放锁");
//            System.in.read();
//            flag = true;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

}
