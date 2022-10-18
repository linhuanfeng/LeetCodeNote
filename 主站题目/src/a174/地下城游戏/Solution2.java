package a174.地下城游戏;

import java.util.Arrays;

/**
 * 动态规划
 *
 * ①统计每一条路径的最低初始健康生命，②还要累计路径当前生命值（是最低初始生命值的前提）
 * 两个重要程度一样，影响着后面的结果，也就是不满足动态规划的无后效性
 * 使用dungeon保存路径累计生命值，记得回溯的时候恢复原值
 *
 * 从后往前进行dp,使用dp[i][j]表示从[i，j]到终点的最低初始生命值
 * dp[i][j]=min(dp[i+1][j],dp[i][j+1])-dungeon[i][j] 注低初始生命值为1，不然无法生存
 * 因为是从后往前，所以是减
 *
 * 比如
 * -2 -3  3
 * -5 -10 1
 * 10 30 -5  1
 *        1
 *
 * 比如 dp[i][j]表示到终点的最小生命值
 * 7  5  2
 * 6  11 5
 * 1  1  6
 *
 * 注意边界值处理
 *
 * 时间：O(2^n)
 * 空间：O(n)栈的深度
 */
// 100
class Solution2 {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length, m = dungeon[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minn = Math.min(dp[i][j+1], dp[i+1][j]); // 找到较小的最小初始值
                dp[i][j] = Math.max(minn - dungeon[i][j], 1); // 至少生命值为1
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().calculateMinimumHP(
                new int[][]{{-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}}));
    }
}