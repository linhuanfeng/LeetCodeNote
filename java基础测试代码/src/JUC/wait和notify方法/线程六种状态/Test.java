package JUC.wait和notify方法.线程六种状态;

/**
 * NEW           新建状态
 * RUNNABLE      可运行状态（包括了就绪和运行状态）
 * BLOCKED       阻塞状态，等待获取锁
 * WAITING       等待状态，wait,join,park
 * TIME_WAITING  超时等待，超时等待，指定时间后自动回到就绪状态
 * TERMINAL      终止状态
 *
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread son = new Thread(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        son.start();
        son.join();
        System.out.println("main....");
    }
}
