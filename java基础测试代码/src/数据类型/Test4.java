package 数据类型;

/**
 * int num1=9_9_9; // 编译正常
 * System.out.println(num1); // 999
 *
 * int num2=_9_99; // 编译无法通过
 *
 *
 *
 * int[][] arr2=new int[4][]; // 编译通过
 * arr2[0]=new int[2];
 *
 * String s[]={"a","a"}; // 编译通过
 */
public class Test4 {
    public static void main(String[] args) {
        int num1=9_9_9;
//        int num2=_9_99; // 编译无法通过
        System.out.println(num1); // 999

        int[][] arr2=new int[4][]; // 编译通过
        arr2[0]=new int[2];

        String s[]={"a","a"}; // 编译通过
//        new String(3); // 没有单个整形的构造函数
    }
}
