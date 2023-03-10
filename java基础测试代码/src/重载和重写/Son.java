package 重载和重写;

public class Son extends Father {
    //    @Override // 无法从写父类的静态方法
//    public static void staticMeth(){
//
//    }


    // 子类隐藏父类方法
    public static void test() {
        System.out.println("son static test");
    }
}
