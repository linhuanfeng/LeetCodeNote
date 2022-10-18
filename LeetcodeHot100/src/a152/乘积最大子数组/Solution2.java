package a152.乘积最大子数组;

/**
 * 常规思路：dp[i]=Math.max(dp[i-1]*nums[i],nums[i]),但是如果当前nums[i]是负数，
 *  那么前一个得是负的，负负得正，得到的结果才是最大
 *  因此，再维护一个dpmin[i]记录最小的值
 *  状态转移方程变成：dp[i]=math.max(dpmax[i-1]*nums[i],dpmin[i-1]*num[i],nums[i])
 */
class Solution2 {
    public int maxProduct(int[] nums) {
        int n=nums.length,ans;
        int dpMax=nums[0]; // 前一个的结果
        int dpMin=nums[0];
        ans=dpMax;
        for (int i = 1; i <n ; i++) {
            int tMax=dpMax; // dpMin要用到当前的值，下一行代码会进行覆盖
            dpMax=Math.max(dpMax*nums[i],Math.max(dpMin*nums[i],nums[i]));
            dpMin=Math.min(tMax*nums[i],Math.min(dpMin*nums[i],nums[i]));
            ans=Math.max(ans,dpMax);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={2,-5,-2,-4,3};
        System.out.println(solution.maxProduct(nums));
    }
}