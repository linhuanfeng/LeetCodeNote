package JUC;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * interrupt（）作用：唤醒轻量级线程
 *      唤醒Thread.sleep(),object.wait(),Thread.join()等轻量级阻塞
 *      线程会抛出InterruptedException并被唤醒
 * t.isInterrupted()和Thread.interrupted()都能判断是否收到过中断信号，后者会重置中断标志位
 */
public class InterruptTest {
    static volatile boolean flag=true;
    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch latch1 = new CountDownLatch(3);
        CountDownLatch latch2 = new CountDownLatch(3);

        Thread thread1 = new Thread(() -> {
            latch1.countDown();
            System.out.println("线程：thread1"  + "开始执行");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程：thread1"+ "安全退出");
                    latch2.countDown();
                    break;
                }
                System.out.println("thread1:Thread.interrupted():"+Thread.interrupted());
            }
        });
        thread1.start();


        Object obj = new Object();
        Thread thread2 = new Thread(() -> {
            try {
                latch1.countDown();
                synchronized (obj){
                    System.out.println("线程：thread2" + "开始执行");
                    obj.wait(); // 注意得在同步代码块中，需要报监视器异常
                }
                System.out.println("thread2:Thread.interrupted():"+Thread.interrupted());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程：thread2" + "安全退出");
                latch2.countDown();
            }
        });
        thread2.start();

        Object obj2=new Object();
        Thread thread3 = new Thread(() -> {
            try {
                latch1.countDown();
                synchronized (obj2){
                    System.out.println("线程：thread3"  + "开始执行");
                    Thread.currentThread().join(); // 一直阻塞直到线程死亡，底层调用wait()方法进行阻塞，所以也要synchronized
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程：thread3" + "安全退出");
                latch2.countDown();
            }
        });
        thread3.start();

        latch1.await();
        System.out.println("输入回车中断thread1、2、3:");
        System.in.read();
        thread1.interrupt(); // 将线程的中断状态置为false,导致抛出interrupted异常，并会重新置中断位为false
        thread2.interrupt();
        thread3.interrupt();

        Thread thread4 = new Thread(() -> {
            while (flag){}// 不能让线程终止了，当线程终止的时候isInterrupted（）方法为false
            System.out.println("thread4:Thread.interrupted():"+Thread.interrupted()); // true
            System.out.println("thread4:Thread.interrupted():"+Thread.interrupted()); // false 因为Thread.interrupted()会重置中断标志
        });
        thread4.start();
        thread4.interrupt();

        latch2.await();
        System.out.println("输入回车验证中断状态：");
        System.in.read();
        System.out.println("thread1是否中断:"+thread1.isInterrupted()); // false 因为InterruptedException异常被捕获后中断标志又记为false
        System.out.println("thread2是否中断:"+thread2.isInterrupted()); // false 因为InterruptedException异常被捕获后中断标志又记为false
        System.out.println("thread3是否中断:"+thread3.isInterrupted()); // false 因为InterruptedException异常被捕获后中断标志又记为false
        System.out.println("thread4是否中断:"+thread4.isInterrupted()); // true
        flag=false;
    }
}
