package a01背包;

import java.util.Scanner;

/**
 * 01背包问题：取dp[i-1][j-c[i]]上一个的最大容量或不取dp[]
 *
 * dp[i][j]表示前i件商品背包容量为j得到的最大价值
 *
 * 不管取和不取，都是从上一个状态转移过来，比如
 * 不取,价值和上一件不变 dp[i][j]=dp[i-1][j]
 * 取，价值等于 dp[i][j]=dp[i-1][j-weight[j]]+value[j]
 *
 * 因此转移方程取最大值，dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[j]]+value[j])
 *
 *
 *  int[][] weight = {{11, 5}, {8, 4}, {2, 2}, {6, 2}, {9, 7}};
 * dp[i][j] i第几块石头，j容量
 * 当前石头拿 dp[i][j]=dp[i-1][j-weight[i-1][0]]+weight[i-1][1]
 * 不拿 dp[i][j]=dp[i-1][j]
 * <p>
 * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 * 0 0 0 0 0 0 0 0 0 0 0 5 5 5 5 5 5 5 5 5 5
 * 0 0 0 0 0 0 0 0 4 4 4 5 5 5 5 5 5 5 5 9 9
 * 0 0 2 2 2 2 2 2 4 4 6 6 6 7 7 7 7 7 7 9 9
 * 0 0 2 2 2 2 2 2 4 4 6 6 6 7 7 7 8 8 8 9 9
 * 0 0 2 2 2 2 2 2 4 7 7 9 9 9 9 9 9 11 11 13 13
 */
public class Main {
    public static void main(String[] args) {
        int m , n = 20;

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split(" ");
        m=strs.length;

        int[][] dp = new int[m + 1][n + 1];
        int[] ans = new int[m];
        int[][] weight = {{11, 5}, {8, 4}, {2, 2}, {6, 2}, {9, 7}};

        weight=new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            String[] split = strs[i].split(",");
            weight[i][0]=Integer.valueOf(split[0]);
            weight[i][1]=Integer.valueOf(split[1]);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= weight[i - 1][0]) {
                    // 放得下
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1][0]] + weight[i - 1][1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int  t_max = dp[m][n];
        for (int i = m; i > 0; i--) {
            for (int k = 1; k <= n; k++) {
                if (dp[i][k] == t_max) {
                    if (dp[i - 1][k] == dp[i][k]) {
                    } else {
                        ans[i-1] = 1;
                        t_max-=weight[i-1][1];
                    }
                    break;
                }
            }
        }
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
}