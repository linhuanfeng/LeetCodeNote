package a122.买卖股票的最佳时机II;

/**
 * 动态规划
 *
 * 股票可以多次买入买出，每次交易至少两天为维度，
 *
 * 使用dp[i][0]表示第i天交易完成后不持有股票
 * 使用dp[i][1]表示第i天交易完成后持有股票
 *
 * dp[i][0]今天交易完不持有股票说明：今天卖出，那么前一天持有股票;或者今天没有交易，前一天卖出股票或者没有交易
 *      即dp[i][0]=max(dp[i-1][1]+p[i],dp[i-1][0])
 *
 * dp[i][1]今天i交易完持有股票说明：今天买入，那么前一天不持有股票;或者今天没有交易，前一天持有的股票
 *      即dp[i][1]=max(dp[i-1][0]-p[i],dp[i-1][1])
 *        0  1
 * 7, 0   0  -7   第一天卖出就是0，卖入就是-7
 * 1, 1   0  -1
 * 5, 2   4  -1
 * 3, 3
 * 6, 4
 * 4  5
 *
 * 局部最优(无后效性，不受后面影响)->全局最优
 *
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution2 {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][0]=0; // 第一天卖出就是0，卖入就是-7
        dp[0][1]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}