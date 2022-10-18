public class EqualsTest {
    public static void main(String[] args) {
        String a="aaa"; // 在字符串常量池中
        String b=new String("aaa"); // 在堆中的非常量池中
        System.out.println(a==b); // false
        System.out.println(a.equals(b)); // true  比较每一个字符是否相等
        System.out.println(a.hashCode());  // 96321 hashCode是相等的，但不是同一个对象
        System.out.println(b.hashCode());  // 96321
        System.out.println("".hashCode()); // 空串的hashCode为0
    }
}
