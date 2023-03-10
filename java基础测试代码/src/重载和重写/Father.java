package 重载和重写;

public class Father {
    private static int i;
    public static void staticMeth() {

    }
    public static void test(){
        System.out.println("father static test");
    }

    public static void f1(Object o){
        System.out.println("Object f1");
    }
    public static void f1(Father o){
        System.out.println("father f1");
    }
}
