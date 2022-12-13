package a376.摆动序列;

/**
 * 尝试动态规划
 * <p>
 * dp[i][1]表示以i作为波峰的最长摆动序列的最长摆动序列长度
 * dp[i][0]表示以i作为波谷的最长摆动序列的最长摆动序列长度
 * <p>
 * dp[i][0]=max(dp[i][0],dp[j][1]+1) 0<j<i&&(j==0||nums[i]<nums[j]) 当前是波谷，那么前一个是波峰
 * dp[i][1]=max(dp[i][1],dp[j][0]+1) 0<j<i&&(j==0||nums[i]＞nums[j]) 当前是波峰，那么前一个是波谷
 * <p>
 *         0  1
 *     0   0  0
 * 1   1   1  1
 * 17  2   1  2
 * 5   3   3  2
 * 10  4   3  4
 * 13  5
 * 15  6
 * 10  7
 * 5   8
 * 16  9
 * 8   10
 * <p>
 * 时间：O(nm)
 * 空间：O(nm)
 */
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[1][0] = 1; // 只有一个元素肯定是摆动序列
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((j == 0) || nums[i - 1] < nums[j - 1]) {// 当前波谷
                    dp[i][0] = Math.max(dp[i][0], dp[j][1]+1);
                }
                if ((j == 0) || nums[i - 1] > nums[j - 1]) {// 当前波峰
                    dp[i][1] = Math.max(dp[i][1], dp[j][0]+1);
                }
            }
        }
        return Math.max(dp[n][0], dp[n][1]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wiggleMaxLength(
                new int[]{1,17,5,10,13,15,10,5,16,8}
        ));
    }
}