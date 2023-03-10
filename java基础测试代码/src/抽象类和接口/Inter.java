package 抽象类和接口;

/**
 * 不能有静态代码块和静态方法
 */
interface Inter {
    public static final int i = 0;
// int j; // 接口变量默认public final static修饰，而final声明的时候就要进行赋值
    public abstract void f1();

    // java8可以有静态方法，但强制需要提供实现
    static void f2() {

    }
}
