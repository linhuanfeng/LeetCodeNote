package JUC.JUC代码;

import java.util.Objects;

//演示用户线程和守护线程
public class Main {

    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        //设置守护线程
        aa.setDaemon(true);
        aa.start();

//        new Thread().join(); // wait(0)

        System.out.println(Thread.currentThread().getName()+" over");

        ThreadLocal<Object> threadLocal=new ThreadLocal<>();
    }
}
