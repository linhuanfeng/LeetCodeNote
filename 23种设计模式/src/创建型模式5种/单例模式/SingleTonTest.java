package 创建型模式5种.单例模式;

public class SingleTonTest {
    public static void main(String[] args) {
        // 双重判断
        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        System.out.println(instance==instance2); // true
        System.out.println("===========================");
        // 枚举的方式
        System.out.println(SingleTon2.singleTon==SingleTon2.singleTon); // true  枚举本身就是单例，不允许使用其构造器创建对象
        System.out.println("===========================");
        // 静态内部类的方式：利用类加载机制，类只会加载一次，静态成员也只会加载一次。
        System.out.println(SingleTon3.getInstance()==SingleTon3.getInstance());
    }
}
