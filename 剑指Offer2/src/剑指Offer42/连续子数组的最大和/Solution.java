package 剑指Offer42.连续子数组的最大和;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        int res=dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
