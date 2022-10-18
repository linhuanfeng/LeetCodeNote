package a45.跳跃游戏II;

import java.util.Arrays;

/**
 * dp
 *
 * dp[i]=Math.min(dp[i],dp[j]+1) 0<=j<i,且nums[j]>=i-j
 *
 * 时间：O（n^2）刚好能过，但效率太低
 * 空间：O(n)
 */
public class Solution2 {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j]>=i-j){
                    // 能到达当前位置，更新最短距离
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[n-1];
    }
}
