package 数据类型;
// 浮点数不能精确表示
public class DoubleTest {
    public static void main(String[] args) {
        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;

        System.out.println(i1==i2); // false
        System.out.println(i3==i4); // false

        System.out.println(3*0.1 == 0.3); // false
    }
}
