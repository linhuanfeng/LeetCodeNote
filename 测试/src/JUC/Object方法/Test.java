package JUC.Object方法;

/*
public final native Class<?> getClass();
public native int hashCode();
public boolean equals(Object obj) {return (this == obj);}
protected native Object clone() throws CloneNotSupportedException;
public String toString() {return getClass().getName() + "@" + Integer.toHexString(hashCode());}
public final native void notify();
public final native void notifyAll();
public final native void wait(long timeout) throws InterruptedException; // 多个重载方法，可以指定重载时间
public final void wait(long timeout, int nanos) throws InterruptedException {} // notify,interrupt,时间到了，就会被唤醒
public final void wait() throws InterruptedException {}
protected void finalize() throws Throwable { } 让线程有机会逃过垃圾回收，通过建立强引用
 */
public class Test {
}
