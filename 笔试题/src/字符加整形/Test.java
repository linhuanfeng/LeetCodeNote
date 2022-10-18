package 字符加整形;

public class Test {
    public static void main(String[] args) {
        System.out.println('a'+0); // 97  因为byte、char、short与int运算会自动转为数据范围更大的int，再进行运算
        System.out.println("a"+0); // a0
    }
}
