package 类方法和实例方法;

/**
 * 静态方法子类无法继承
 * 实例方法可直接调用本类的所有方法，父类的实例方法要注意访问修饰符
 * 实例方法不可直接调用超类的类方法
 * 类方法无法调用实例方法，因为实例方法还未初始化
 */
public class Father {
    // 静态方法子类无法继承
//    public static void f1(){
//        System.out.println("father:s1");
//    }

    public void f2(){
//        f1(); // 实例方法不可直接调用超类的类方法
        f3(); // 可直接调用本类的类方法
    }

    public static void f3(){
//        f4(); // 类方法无法调用实例方法，因为实例方法还未初始化
    }

    public void f4(){}
}
