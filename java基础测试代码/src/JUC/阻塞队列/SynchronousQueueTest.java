package JUC.阻塞队列;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        synchronousQueue.poll();
        boolean offer1 = synchronousQueue.offer(1);
        System.out.println(offer1); // false

        new Thread(()->{
            try {
                synchronousQueue.poll(100,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        boolean offer2 = synchronousQueue.offer(1,100, TimeUnit.MILLISECONDS);
        System.out.println(offer2); // true

        System.out.println("end");
    }
}
