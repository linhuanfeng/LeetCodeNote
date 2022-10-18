package JUC.JUC代码.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//阻塞队列
public class BlockingQueueDemo2 {

    public static void main(String[] args) throws InterruptedException {
        //创建阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(2);

        //第三组
        new Thread(()->{
            try {
                blockingQueue.put("a");
                blockingQueue.put("b");
                blockingQueue.put("c"); // 队列满阻塞住，调用condition.await()释放了锁，
                                            // 所以消费者线程可以拿到锁并从队列中消费
                System.out.println("全部put完成");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(2000);

//        blockingQueue.put("c"); // 会阻塞
//        //blockingQueue.put("w");
//
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take()); // 会阻塞
    }
}
