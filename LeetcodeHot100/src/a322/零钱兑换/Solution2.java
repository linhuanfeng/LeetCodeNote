package a322.零钱兑换;


import java.util.Arrays;

/**
 * 动态规划
 *
 * 使用dp[i][j]表示前i个硬币凑够j元所需的最少次数
 *
 * m表示不存在或不能整取
 *
 *      0 1 2 3 4 5 6 7 8 9 10 11
 *   0  0 m m m m m m m m m m  m
 * 1 1  0 1 2 3 4 5 6 7 8 9 10 11
 * 2 2  0 1 1 2 2 3 3 4 4 5 5  6
 * 5 3  0 1 1 2 2 1 2 2 3 3 2  3
 *
 * 时间：O(nm)
 * 空间：O(nm)
 */
public class Solution2 {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];

        Arrays.fill(dp[0],Integer.MAX_VALUE);
        dp[0][0]=0;

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= amount; j++) {
                dp[i][j]=Integer.MAX_VALUE;// 当前零钱不取
                int cnt=0;
                while (coins[i-1]*cnt<=j){ // 当前零钱取1 2 3 ...
                    if(dp[i-1][j-coins[i-1]*cnt]<Integer.MAX_VALUE){ // 表示可达，可整凑
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][j-coins[i-1]*cnt]+cnt);
                    }
                    cnt++;
                }
            }
        }
        return dp[n][amount]==Integer.MAX_VALUE?-1:dp[n][amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().coinChange(
                new int[]{2}, 3));
    }
}
