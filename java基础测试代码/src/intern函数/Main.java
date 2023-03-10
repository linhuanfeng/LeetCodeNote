package intern函数;


/**
 * intern返回字符串常量池中的地址
 *
 * jdk1.7后字符串常量池放在堆中
 */
public class Main {
    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
    }
    public static void test3(){
        String s3 = new String("a") + new String("a"); // a放入常量池，堆中创建对象aa
        s3.intern(); // 常量池中创建aa,并指向堆中的s3
        String s4 = "aa";
        System.out.println(s3 == s4); // jdk78 true

        String s5 = new String("b"); // b放入常量池，堆中生成对象a
        String s6 = "b"; // 常量池
        String s7 = s5.intern(); // 常量池
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // true
    }

    public static void test2() {
        String str1 = new String("hello" + "world"); // 堆 同时在方法区常量池生成helloworld,都是常量不会使用stringBuilder
        String str1_intern = str1.intern(); // 常量池 直接返回常量池中的helloworld,因为上一个语句已将helloworld放入常量池
        String str2 = "hello" + "world"; // 常量池
        String word = "word"; // 常量池生成word
        String str3 = new String("hello" + word); // 堆 有一个是变量就是用builder,因为编译时不知道变量的具体值
        System.out.println(str1 == str2); // false 因为str1指向堆，str2指向常量池
        System.out.println(str1 == str1_intern); // false str1_intern返回的常量池的地址
        System.out.println(str2 == str1_intern); // true
        System.out.println(str1 == str3); // false 两个是不同的普通的堆对象
    }

    public static void test1() {
        String str2 = new String("hello"); // 指向堆中的地址，但实际引用的是堆中的字符串常量池地址
        String str3 = str2.intern(); // 如果常量池没有，则创建一个，并指向堆中的str2；否则返回常量池中的引用
        String str1 = "hello"; // 指向常量池
        System.out.println(str1 == str2); // false
        System.out.println(str1 == str3); // true
        System.out.println(str2 == str3); // false str2执行堆，str1指向常量池
    }
}
