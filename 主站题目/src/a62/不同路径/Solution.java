package a62.不同路径;

import java.util.Arrays;

/**
 * 考虑动态规划，从下到上，从右到左
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        Arrays.fill(dp[m-1],1);
        for (int i = 0; i < m; i++) {
            dp[i][n-1]=1;
        }
        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}