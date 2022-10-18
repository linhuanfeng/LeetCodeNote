package static关键字;

public class Test {
    public static void staticMethod(){
        System.out.println("实例方法可直接调用类方法"); // 但类方法不能调实例方法，因为实例方法还没加载
    }

    public static void main(String[] args) {
        new Son().f3(); // a:1
        new Son().f3(); // a:2 静态变量所以是同一个
    }
}
