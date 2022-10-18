package JUC.阻塞队列.七种阻塞队列;


import java.util.PriorityQueue;
import java.util.concurrent.*;

/**
 * 1、ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列
 *
 * 2、LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列（常用）
 *
 * 3、PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列
 *
 * 4、DelayQueue： 一个使用优先级队列实现的无界阻塞队列
 *
 * 5、SynchronousQueue： 一个不存储元素的阻塞队列（常用）
 *
 * 6、LinkedTransferQueue： 一个由链表结构组成的无界阻塞队列
 *
 * 7、LinkedBlockingDeque： 一个由链表结构组成的双向阻塞队列
 */
public class Test {
    public static void main(String[] args) {
        new ArrayBlockingQueue<Integer>(10,true); // 数组 有界
        new LinkedBlockingQueue<Integer>(Integer.MAX_VALUE); // 链表 有界
        new PriorityQueue<Integer>(10); // 优先级堆 无界
        new DelayQueue<RunnableScheduledFuture>(); // 基于优先级队列实现的误解延迟队列
        new SynchronousQueue<Integer>(); // 不存储元素
        new LinkedTransferQueue<Integer>();
        new LinkedBlockingQueue<Integer>();
    }
}
