package 代码阅读;

public class Test6 {
    public static void main(String[] args) {
        System.out.println(getNumber(0)); // -1
        System.out.println(getNumber(1)); // 1
        System.out.println(getNumber(2)); // 1
        System.out.println(getNumber(4)); // 0
    }

    public static int getNumber(int n) {
        try {
            int result = 2 / n;
            return result; // 不会再执行
        } catch (Exception e) {
            return 0;// catch有return，则try的return不会执行
        } finally {// finally有return，则会覆盖catch和try的返回值
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return 1;
            }
        }
    }
}
