package java8接口;

public interface InterfaceNew {
    default void f1(){
        f2();
    };
    static void f2(){};
    void f3();
}
