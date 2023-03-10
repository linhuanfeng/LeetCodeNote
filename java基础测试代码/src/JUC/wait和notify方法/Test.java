package JUC.wait和notify方法;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        for (int i = 1; i <= 10; i++) {
            new Thread(new WaitNotifyTest(true,obj),"thread-"+i).start();
        }
        Thread.sleep(2000);
        System.out.println("睡眠两秒后，开启一个线程去通知notify");
        new Thread(new WaitNotifyTest(false,obj),"thread-"+"11").start();


    }
}
