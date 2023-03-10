package JUC;

public class ThreadLocalTest {
    static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            // 其实就是设置当前Thread中的threadLocalMap，key为定义threadLocal对象this的引用
            threadLocal.set(Thread.currentThread().getName()+"-v1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadLocal.get()); // 打印的还是thread1-v1，线程私有，不会被thread2修改
            threadLocal.remove(); // 一定要remove不然会内存泄露
        },"thread1").start();

        Thread.sleep(1000);

        new Thread(()->{
            threadLocal.set(Thread.currentThread().getName()+"-v3");
            System.out.println(threadLocal.get());
            threadLocal.remove();
        },"thread2").start();
    }
}
