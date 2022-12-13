package a123.买卖股票的最佳时机III;

/**
 * 动态规划：
 * 定义状态：
 * 假设第i天交易完成后有如下几种状态
 *
 * 未买入过一次股票 利润为0
 * 买入过一次股票，未卖出 buy1[i] 表示前i次价格买入未买出能得到的最大价值
 * 买入过一次股票，已卖出 sell1
 * 买入两次股票，未买出  buy2
 * 买入两次股票，已卖出 sell2
 *
 *
 * buy1=max(buy1_,-prices[i-1]) 保持上一次buy1状态，或者第一次买入
 * sell1=max(sell1_,buy1_+prices[i-1]) 保持上一次sell1_的状态，或者当前卖出buy1_+prices[i-1]
 * buy2=max(buy2_,sell1_-prices[i-1]) 保持上一次状态，或者当前买入
 * sell2=max(sell2_,buy2_+prices[i-1]) 保持上一次状态，或者当前卖出
 *
 * 当前买入并卖出收益为0，不必考虑
 *
 *           3, 3, 5, 0, 0, 3, 1, 4
 *        0  1  2  3  4  5  6  7  8
 * buy1   0  -3 -3 -3 0  0  0  0  0 //一定得买
 * sell1  0  0  0  2  2  2  3  3  4
 * buy2   0  0  0  0  2  2  2  2  2
 * sell2  0  3  3  5  5  5  5  5  6
 *
 *           3, 3, 5, 0, 0, 3, 1, 4
 *        0  1  2  3  4  5  6  7  8
 * buy1   0  -3 -3 -3 0  0  0  0  0 // 一定得买一个，才能满足`只买入一只股票且未卖出`的定义
 * sell1  0  0  0  2  2  2  3  3  4 // 对于sell1和sell2的第一支股票收益为0
 * buy2   0 -3 -3 -3  2  2  2  2  2 // 一定得买一个，才能满足
 * sell2  0  0  0  2  2  2  5  5  6
 *
 *           1, 2, 3, 4, 5
 *        0  1  2  3  4  5
 * buy1   - -1 -1 -1 -1 -1 //一定得买
 * sell1  0  0  1  2  3  4
 * buy2   0  -1 -1 -1 -1 -1
 * sell2  0  0  1  2  3  4
 *
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] buy1=new int[n+1],sell1=new int[n+1],buy2=new int[n+1],sell2=new int[n+1];

        buy1[1]=-prices[0]; // 边界值处理，第一个股票只能买入，对于sell1和sell2的第一支股票收益为0
        buy2[1]=-prices[0]; //
        for (int i = 2; i <=n ; i++) {
            buy1[i]=Math.max(buy1[i-1],-prices[i-1] );
            sell1[i]=Math.max(sell1[i-1],buy1[i-1]+prices[i-1] );
            buy2[i]=Math.max(buy2[i-1], sell1[i-1]-prices[i-1]);
            sell2[i]=Math.max(sell2[i-1],buy2[i-1]+prices[i-1]);
        }
        return sell2[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().
                maxProfit(new int[]{1,2,3,4,5}));
    }
}