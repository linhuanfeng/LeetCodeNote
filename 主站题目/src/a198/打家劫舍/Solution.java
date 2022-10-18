package a198.打家劫舍;

/**
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return nums[0];
        if(nums.length==1)return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=0;
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            max=Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,1,1,2};
        System.out.println(solution.rob(nums));
    }
}