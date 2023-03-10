package 输入输出测试;

import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // 读取空格，不然被下面读取了
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            System.out.println(sb);
        }
    }
}
