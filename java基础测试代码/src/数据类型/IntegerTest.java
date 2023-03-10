package 数据类型;

public class IntegerTest {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("001")); // 1
        System.out.println(Integer.valueOf("-001")); // -1

        System.out.println("##############");
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2); // true
        System.out.println(i3==i4); // false
    }
}
