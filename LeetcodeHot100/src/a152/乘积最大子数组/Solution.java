package a152.乘积最大子数组;

/**
 * 常规思路：dp[i]=Math.max(dp[i-1]*nums[i],nums[i]),但是如果当前nums[i]是负数，
 *  那么前一个得是负的，负负得正，得到的结果才是最大
 *  因此，再维护一个dpmin[i]记录最小的值
 *  状态转移方程变成：dp[i]=math.max(dpmax[i-1]*nums[i],dpmin[i-1]*num[i],nums[i])
 */
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length,ans;
        int[] dpMax=new int[n];
        int[] dpMin=new int[n];
        System.arraycopy(nums,0,dpMax,0,n);
        System.arraycopy(nums,0,dpMin,0,n);
        for (int i = 1; i <n ; i++) {
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i]=Math.min(dpMax[i-1]*nums[i],Math.min(dpMin[i-1]*nums[i],nums[i]));
        }
        ans=dpMax[0];
        for (int i = 1; i < n; i++) {
            ans=Math.max(ans,dpMax[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,-5,-2,-4,3};
        System.out.println(solution.maxProduct(nums));
    }
}