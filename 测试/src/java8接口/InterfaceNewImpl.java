package java8接口;

public class InterfaceNewImpl implements InterfaceNew {
    @Override
    public void f1() {
        InterfaceNew.super.f1();
    }

    // static修饰的不能被重写

    @Override
    public void f3() {

    }

    public static void f4(){
        System.out.println("father的f4");
    }; // static方法不能别重写,因为类加载的时候
}
