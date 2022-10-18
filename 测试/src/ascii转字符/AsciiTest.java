package ascii转字符;


public class AsciiTest {
    public static void main(String[] args) {
        //ASCii码值转换成对应的字符 直接强制转换成char型就可以实现了
        System.out.println((char) 48); // 输出0
        System.out.println((char) 65); // 输出A
        System.out.println((char) 97); // 输出a

        System.out.println((int) '0'); // 48,转为ascii码对应的值
        System.out.println((int) 'A'); // 65
        System.out.println((int) 'a'); // 97

        char c1 = 'a';
        System.out.println(c1); // a
        System.out.println(c1 + 1); // 98，char会自动转为int类型再计算

		System.out.println(Integer.valueOf('0')); // 输出48,因为'0'会先被转为48
    }
}
