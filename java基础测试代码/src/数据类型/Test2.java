package 数据类型;

/**
 * 变量类型：范围小的会自动转换成大的，反过来就得强制类型转换.浮点数范围大于整形
 * 1     2     2      4    8     4      8
 * byte->char->short->int->long->float->double
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MAX_VALUE+1); // -2147483648
        System.out.println(Integer.MAX_VALUE+2); // -2147483647

//        int a=2147483648; // 编译失败，超过整形范围
        long l1=2147483648l; // long型
        long l2=2147483647; // 整数默认是int类型，赋值给范围更大的不用强制类型转换
        int i='a'; // 同上

//        float f1=0.1;  编译不过
        float f1=0.1f;  // 编译通过
        double d=0.1; // 编译通过，因为浮点数默认就是double类型

        // 变量类型：范围小的会自动转换成大的，反过来就得强制类型转换
        // 1     2     2      4    8     4      8
        // byte->char->short->int->long->float->double
        double d2=100;
        int i1= (int) d2; // 这个就得强制类型转换了

        int i2=-1/2;
        System.out.println(i2); // 0

        double d3=-1/2;
        System.out.println(d3); // 0.0 因为1/2默认是整形计算，得到0，再赋给double类型

        float f2=-1/2;
        System.out.println(f2); // 0.0

        // char+int 自动转成 int+int
        System.out.println('a'+0); // 97  因为byte、char、short与int运算会自动转为数据范围更大的int，再进行运算
        System.out.println("a"+0); // a0

    }
}
