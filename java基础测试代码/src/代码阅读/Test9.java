package 代码阅读;

public class Test9 {
    static int a=20;
    static {
        a+=5;
    }
    public static void main(String[] args) {
        System.out.println(a); // 8
    }
    static {
        a/=3;
    }
}
