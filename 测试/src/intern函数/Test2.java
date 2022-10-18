package intern函数;

/**
 *
 */
public class Test2 {
    public static void main(String[] args) {
        String s1 = new String("二哥三妹");
        String s2 = s1.intern();
        System.out.println(s1 == s2); // false

        String s3 = new String("张三")+new String("王五");
        String s4 = s3.intern();
        System.out.println(s3 == s4); // true
    }
}
