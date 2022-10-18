package GC;

public class TestSystemGC {
    public static void main(String[] args) {
        new TestSystemGC(); //提醒JVM的垃圾收集器执行gc操作，但不确保一定会执行
        System.gc(); // 高速垃圾回收器尽最大努力回收垃圾
        //System.runFinalization(); //强制调用失去引用对象的finalize方法
    }
 
 
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("TestSystemGC重写的finalize方法被执行了！！！");
 
    }
}