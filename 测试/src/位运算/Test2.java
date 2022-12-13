package 位运算;

/**
 * 位运算只能左移或右移非负数
 * 否则会有意想不到的事情，1<<-2 = 1073741824
 */
public class Test2 {
    public static void main(String[] args) {
        int a=13;// 1101
        System.out.println(a); // 13
        a=a|1<<1;
        System.out.println(a); // 15
        a=a^1<<1;
        System.out.println(a); // 13
        System.out.println(1<<-2); // 1073741824
    }
}
