package JUC.thread方法;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.LockSupport;

/**
 * start
 * run
 * join
 * interrupt
 * getPriority
 * setDaemon
 * wait
 * notify
 * exit
 */
/*
public static native Thread currentThread();
public static native void yield();
public static native void sleep(long millis) throws InterruptedException;
public static void sleep(long millis, int nanos) throws InterruptedException {}
public synchronized void start() {}
public void run() {}实现runnable接口
private void exit() {}
public final void stop() {} @Deprecated
public void interrupt() {}
public static boolean interrupted(){} 调用isInterrupted(true)
public boolean isInterrupted(){}
private native boolean isInterrupted(boolean ClearInterrupted);
public void destroy() {throw new NoSuchMethodError();} @Deprecated 冻结导致死锁
public final native boolean isAlive();
public final void suspend() {} @Deprecated
public final void resume() {} @Deprecated
public final void setPriority(int newPriority){}
public final int getPriority(){}
public final synchronized void setName(String name) {}
public final String getName(){}
public final ThreadGroup getThreadGroup(){}
public static int activeCount(){}
public static int enumerate(Thread tarray[]){}
public native int countStackFrames();
public final synchronized void join(long millis, int nanos) throws InterruptedException {}
public final void join() throws InterruptedException {}
public static void dumpStack() {}
public final void setDaemon(boolean on){} 守护线程产生的线程也是守护线程
public final boolean isDaemon(){}
public final void checkAccess() {}
public ClassLoader getContextClassLoader(){} @CallerSensitive
public void setContextClassLoader(ClassLoader cl){}
public StackTraceElement[] getStackTrace(){}
public long getId(){}
 */
enum State {
    /**
     * Thread state for a thread which has not yet started.
     */
    NEW,

    /**
     * Thread state for a runnable thread.  A thread in the runnable
     * state is executing in the Java virtual machine but it may
     * be waiting for other resources from the operating system
     * such as processor.
     */
    RUNNABLE,

    /**
     * Thread state for a thread blocked waiting for a monitor lock.
     * A thread in the blocked state is waiting for a monitor lock
     * to enter a synchronized block/method or
     * reenter a synchronized block/method after calling
     * {@link Object#wait() Object.wait}.
     */
    BLOCKED,

    /**
     * Thread state for a waiting thread.
     * A thread is in the waiting state due to calling one of the
     * following methods:
     * <ul>
     *   <li>{@link Object#wait() Object.wait} with no timeout</li>
     *   <li>{@link #join() Thread.join} with no timeout</li>
     *   <li>{@link LockSupport#park() LockSupport.park}</li>
     * </ul>
     *
     * <p>A thread in the waiting state is waiting for another thread to
     * perform a particular action.
     *
     * For example, a thread that has called <tt>Object.wait()</tt>
     * on an object is waiting for another thread to call
     * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
     * that object. A thread that has called <tt>Thread.join()</tt>
     * is waiting for a specified thread to terminate.
     */
    WAITING,

    /**
     * Thread state for a waiting thread with a specified waiting time.
     * A thread is in the timed waiting state due to calling one of
     * the following methods with a specified positive waiting time:
     * <ul>
     *   <li>{@link #sleep Thread.sleep}</li>
     *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
     *   <li>{@link #join(long) Thread.join} with timeout</li>
     *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
     *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
     * </ul>
     */
    TIMED_WAITING,

    /**
     * Thread state for a terminated thread.
     * The thread has completed execution.
     */
    TERMINATED;
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.run();
        thread.join();
        thread.interrupt();
        thread.getPriority();
//        private void exit() {}
        thread.setPriority(1);
        thread.setDaemon(false);
        thread.isAlive();
        thread.wait();
        thread.notify();
        thread.getId();
        thread.stop();
    }
}
