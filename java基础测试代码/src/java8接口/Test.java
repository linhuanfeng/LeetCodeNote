package java8接口;

import java.util.ArrayList;

/**
 * static修饰的方法不能重写，因为是类的
 */
public class Test {
    public static void main(String[] args) {
        InterfaceNewImpl interfaceNew= new InterfaceNewImplSub();
        interfaceNew.f4(); // father的f4 static不能重写，只是隐藏
        System.out.println(~0); // -1
        System.out.println(~1); // -2
        System.out.println(~(-1)); // 0
        System.out.println(~(2)); // 3
        System.out.println(~(-2)); // 1
//        ArrayList
    }
}
