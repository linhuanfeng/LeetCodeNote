package a377.组合总和Ⅳ;

/**
 * 由于顺序不同的序列也视作不同的组合，所以题目要求所有和为target的组合的全排列，比‘39.组合总和’多了组合的排列
 * 采用动态规划
 * dp[target]+=dp[i] i[0-n-1]
 * 这样做有没有考虑到了排列呢，有的，因为从1-n遍历，1和3的此书也累加了
 * dp[0]=1,所有都不取只有一种情况
 *
 * 时间：O(n^2)
 * 空间：O(n)
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}