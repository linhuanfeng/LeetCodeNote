package 迷宫随机生成;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("0");
                if(j!=n-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
}
