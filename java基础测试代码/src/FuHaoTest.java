public class FuHaoTest {
    public static void main(String[] args) {
        // 异或：判断带符号整数是否同号，因为最高位是符号位
        System.out.println((-1)^(-2)); // >0
        System.out.println((1)^(2)); // >0
        System.out.println((1)^(-2)); // <0 异号小于0
    }
}
