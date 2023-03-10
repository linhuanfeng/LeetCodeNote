package JUC.wait和notify方法;

/**
 * Wait()表示等待某个信号量，属于Object类(因为每个对象都拥有对象锁),需要notify()或notifyAll()通知去唤醒
 * 需要在同步代码块内
 */
public class WaitNotifyTest implements Runnable{
    private Object obj;
    private volatile boolean flag;
    WaitNotifyTest(boolean flag,Object o){
        this.obj=o;
        this.flag=flag;
    }
    private void waitMethod(){
        synchronized (obj){
            try {
                System.out.println(Thread.currentThread().getName()+"wait-begin");
                obj.wait();
                System.out.println(Thread.currentThread().getName()+"wait-after");
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName()+"wait-catch");
            }
        }
    }

    private void notifyMethod(){
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"notify-begin");
//            obj.notify(); // 只能通知一个线程
            obj.notifyAll(); // 通知所有线程
            System.out.println(Thread.currentThread().getName()+"notify-after");
        }
    }

    @Override
    public void run() {
        if(flag)waitMethod();
        else notifyMethod();
    }
}
