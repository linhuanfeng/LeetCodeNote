package 数据类型;

/**
 *
 *  char和short都是占用两个字节
 *
 *  String不是关键字，只是常用类,是引用数据类型;string啥都不是
 *
 * byte,char,short计算的时候都会自动转为int类型
  */
public class Test1 {
    public static void main(String[] args) {
        byte b1 = 1, b2 = 2, b3, b6;
        final byte b4 = 4, b5 = 6;

        b6 = b4 + b5;
        b3= (byte) (b1+b2); // b1+b2会自动转为int类型，所以需要强制转换
        b6=127;
        b6= (byte) 128; // 超过一字节需要强转

        char c1 = '1', c2 = '2', c3;
        c3= (char) (c1+c2); // 自动转为int类型进行运算，所以需要强制转换

        short s1 = 1, s2 = 2, s3;
        s3= (short) (s1+s2); // 同上

        s1= (short) c1; // short和char之间也要相互强制转换
        c1= (char) s1;

        c1='c';
        System.out.println(c1); // c

        String str1="a";
        System.out.println(str1.concat("b")); // ab

        String string=""; // String和string都不是关键字

//        int[10][10] a; // 编译报错
//        int a[10][10] a; // 编译报错
        int a[][]=new int[10][10];
    }
}
