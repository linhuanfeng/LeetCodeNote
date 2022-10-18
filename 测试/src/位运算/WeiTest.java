package 位运算;

public class WeiTest {

    /**
     * 按位与
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(13&1); // 1 ==> 1101 & 0001 = 1
        System.out.println(12&1); // 0 ==> 1100 & 0001 = 0
        System.out.println(-5&6); //111011 & 0000110 =2
        System.out.println("====================");
        System.out.println(2>>1); // 1
        System.out.println("====================");
        System.out.println(1&0); // 0
        System.out.println(0&0); // 0
        System.out.println(1&1); // 1
        System.out.println("====================");
        /**
         * 右移共分为两种：
         * 无符号右移（将二进制位右移，低位舍弃，高位补0）
         * 有符号右移 （将二进制位右移，低位舍弃，高位补符号位）
         */
        System.out.println(1>>1);  // 0
        System.out.println(1>>>1); // 0
        System.out.println(-1>>1);  // -1
        System.out.println(-1>>>1); // 2147483647
    }
}
