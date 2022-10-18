package 创建型模式.单例模式;

/**
 * 1. 遇到 new、getstatic、putstatic、或者invokestatic 这4条字节码指令，如果没有类没有进行过初始化，则触发初始化
 *
 * 　2. 使用java.lang.reflect包的方法，进行反射调用的时候，如果没有初始化，则先触发初始化
 *
 * 　3. 初始化一个类时候，如果发现父类没有初始化，则先触发父类的初始化
 */

/**
 * 静态内部类的方式--》懒加载
 * 优点：因为外部类对内部类的引用属于被动引用，不属于前面三种初始化方式，所以不会加载内部类。
 * 同时JVM会保证一个类的<cinit>()方法执行时的线程安全，从而保证全局唯一
 */
public class SingleTon3 {
    private static class innerSingle3{
        private static SingleTon3 singleTon3=new SingleTon3();
    }
    public static SingleTon3 getInstance(){
        return innerSingle3.singleTon3;
    }
}
