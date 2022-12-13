package a53.最大子数组和;

/**
 * 使用dp[i]表示以i结尾的子数组的最大和
 *
 * 时间：O(n)
 * 空间：O(n)
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int res=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
