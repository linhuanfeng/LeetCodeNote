package a279.完全平方数;

import java.util.Arrays;

/**
 * 动态规划：f(i)可选数字范围为[1,1-根号i]，那么假设最后一个取j,
 *  f(i)=1+f(i-j),那么转移方程：f(i)=Math.min(f(j))+1 j从1到i
 */
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(13));
    }
}