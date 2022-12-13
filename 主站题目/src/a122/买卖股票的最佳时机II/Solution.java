package a122.买卖股票的最佳时机II;

/**
 * 贪心算法
 *
 * 股票可以多次买入买出，每次交易至少两天为维度，
 * 只需统计所有，因此可以统计所有的
 * 比如2 5 7 很明显第一天买入，第三天卖出得到最大的5
 * 其实等价于 第一天买入，第二天卖出，第二天买入，第三天卖出
 * 即(p[3]-p[2])+(p[2]-p[1])
 * 7, 1, 5,  3,  6,  4
 *   -6  4  -2   3  -2
 * 那么就可以把正数加起来即可
 *
 * 局部最优->全局最优
 *
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int res=0;

        for (int i = 1; i < prices.length; i++) {
            int t=prices[i]-prices[i-1];
            if(t>0){
                res+=t;
            }
        }
        return res;
    }
}