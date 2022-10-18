package 类加载.触发类加载;

/**
 * 编译器常量不会触发类的加载
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Test2.a);
        System.out.println(Test3.name);
    }
}

class Test2 {
    public static final String a = "JD"; // 编译器常量不会触发类的加载
//    public static final String a = new String("JD"); // 触发类的加载，因为不是编译器常量

    static {
        System.out.print("OK");
    }
    { // 类加载不包括非静态代码块代码
        System.out.println("AA");
    }
}
class Test3{
    static {
        name="BBBB";
    }
    { // 类加载不包括非静态代码块代码
        name="AAAA";
    }
    public static String name;
}