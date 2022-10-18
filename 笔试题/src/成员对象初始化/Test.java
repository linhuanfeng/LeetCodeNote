package 成员对象初始化;

/**
 * 基本数据类型有零值
 * 对象初始为null
 */
public class Test {
    int x; // 基本数据类型有零值，即0
    Integer i; // 对象初始为null
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.x); // 基本
        System.out.println(test.i+1); // 空指针异常
    }
}
