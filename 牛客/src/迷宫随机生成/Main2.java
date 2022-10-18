package 迷宫随机生成;

import java.util.Random;
import java.util.Scanner;

/**
 * 孤岛，说明被障碍围起来
 * 随机生成一个联通的路径，其他位置全部用1填充
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        Random random = new Random();



        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(random.nextInt(2));
                if(j!=n-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }
    }
    void dfs(boolean[][] arr,int x,int y){

    }
}
