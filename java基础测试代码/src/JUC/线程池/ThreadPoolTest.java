package JUC.线程池;

import java.util.concurrent.Executors;

/**
 * 拒绝策略：
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        ThreadLocal
        Thread.currentThread().interrupt();

        // java提供四种内置的线程池封装，本质通过ThreadPoolExecutor进行创建

        /**
         * 单线程数的线程池（核心线程数=最大线程数=1）
         * new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,
         *                                     new LinkedBlockingQueue<Runnable>())
         */
        Executors.newSingleThreadExecutor();

        /**
         * 固定线程数的线程池（核心线程数=最大线程数=自定义）
         * new ThreadPoolExecutor(nThreads, nThreads,
         *                                       0L, TimeUnit.MILLISECONDS,
         *                                       new LinkedBlockingQueue<Runnable>()
         */
        Executors.newFixedThreadPool(10);

        /**
         * 可缓存的线程池（核心线程数=0，最大线程数=Integer.MAX_VALUE）
         * new ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,
         *                                  new SynchronousQueue<Runnable>());
         */
        Executors.newCachedThreadPool();

        /**
         * 支持定时或周期任务的线程池（核心线程数=自定义，最大线程数=Integer.MAX_VALUE）
         * new ThreadPoolExecutor(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
         *               new DelayedWorkQueue()
         */
        Executors.newScheduledThreadPool(10);




    }
}
