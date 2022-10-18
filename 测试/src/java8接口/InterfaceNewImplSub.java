package java8接口;

public class InterfaceNewImplSub extends InterfaceNewImpl {
    @Override
    public void f1() {
        super.f1();
    }

    @Override
    public void f3() {
        super.f3();
    }
    public static void f4(){
        System.out.println("son的f4,只是隐藏不是重写或多态");
    }; // static方法不能别重写,因为类加载的时候
}
