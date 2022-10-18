package 剑指Offer47.礼物的最大价值;

/**
 * 因为只能向右或下走，所以到达点grid[i][j]必须经过grid[i-1][j]或grid[i][j-1]
 * 因此最大值dp[i][j]=max(dp[i-1][j],dp[i][j-1])+grid[i][j]
 * 时间复杂度：O(nm) 动态规划每个节点都要走一遍
 * 空间复杂度：O(n*m) dp数组的开销
 */
public class Solution3 {
    public int maxValue(int[][] grid) {
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for (int i = 1; i <=grid.length ; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
