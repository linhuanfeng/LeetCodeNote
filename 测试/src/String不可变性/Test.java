package String不可变性;

/**
 * 不可变实现原理
 * public final class String 首先String类不可被继承，防止被子类进行修改
 *     implements java.io.Serializable, Comparable<String>, CharSequence {
 *
 *     private final char value[];
 *     char数组value[]被private和final修饰，正常情况下是无法修改地址值和内容（反射可以修改内容）
 *     改变String的值本质就是指向新的引用
 *
 * 为什么要不可变：
 * 线程安全：不可变对象一定是线程安全的
 * 让字符串常量池有意义，否则
 */
public class Test {
    public static void main(String[] args) {
        String str = new String("abc");
        System.out.println(str.hashCode()); // 96354

        str+="aaa";
        System.out.println(str.hashCode()); // -1424388961 已经指向新的地址了
    }
}
