package a312.戳气球;

/**
 * 动态规划，由于每次戳破气球会导致新的气球成为相邻，那么转换思路，
 * 假设初始1，1，（注意两个气球不能被戳破），每次都从里面加气球
 * dp[i][j]表示开区间内获得的最大金币，开区间表示气球i,j不能被戳
 * dp[i][j]=dp[i][k]+val[i]*val[k]*val[j]+dp[k][j]
 * 为什么要加上dp[i][k]和dp[k][j]，只剩下气球k的时候，左右两边的气球已经被戳破了，
 * 获得的金币就要记录在dp[i][k]和dp[k][j]中
 *
 * 时间：O(n^3)
 * 空间：O(n^2)
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] val = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        for (int i = n-1; i >=0; i--) {
            for (int j = i + 2; j < n +2; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = dp[i][k] + val[i] * val[k] * val[j] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }
}