package 输入输出测试;

import java.util.Scanner;

public class NextInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        /**
         * 1
         * 2
         * 1 2
         * ========== 遇到回车程序才结束
         * 1 2
         * 1 2
         */
        System.out.println(i+" "+j);
    }
}
