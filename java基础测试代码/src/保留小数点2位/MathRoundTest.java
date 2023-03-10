package 保留小数点2位;
// Math.round趋向正无穷
public class MathRoundTest {
    public static void main(String[] args) {
        double a1=1.5;
        double a2=-1.5;
        double a3=1.4;
        double a4=-1.4;
        System.out.println(Math.round(a1)); // 2
        System.out.println(Math.round(a2)); // -1
        System.out.println(Math.round(a3)); // 1
        System.out.println(Math.round(a4)); // -1
    }
}
