package JUC.JUC代码;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BooleanLatch {
    private static class Sync extends AbstractQueuedSynchronizer {
        boolean isSignalled() { // 是否通知了，初始stat=0表示没有收到通知
            return getState() != 0;
        }

        protected int tryAcquireShared(int ignore) { // 是否获取资源成功
            return isSignalled() ? 1 : -1; // 大于0获取成功，唤醒所有阻塞的线程
        }

        protected boolean tryReleaseShared(int ignore) {
            setState(1); // 释放锁，状态置为1，增加资源
            return true;
        }
    }

    private final Sync sync = new Sync();

    public boolean isSignalled() {
        return sync.isSignalled();
    }

    public void signal() {
        // 释放资源，模板方法，调用tryReleaseShared，成功则共享模式下的通知后继结点
        sync.releaseShared(1);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(1); // 会调用tryAcquireShared，小于0就会阻塞
    }

    public static void main(String[] args) throws InterruptedException {
        BooleanLatch latch = new BooleanLatch();
        new Thread(()->{
            try {
                System.out.println("3秒后通知释放资源");
                Thread.sleep(3000);
                latch.signal(); // 状态置为1，release资源
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        latch.await(); // 等待状态置为1
        System.out.println("执行。。");
    }
}