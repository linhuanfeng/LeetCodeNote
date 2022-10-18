package 剑指Offer63.股票的最大利润;

/**
 * 只需买卖一次，那么一次遍历即可
 */
public class Solution3 {
    public int maxProfit(int[] prices) {
        if(prices.length<2)return 0;
        int minVal=prices[0],res=0;

        for (int i = 0; i < prices.length; i++) {
            res=Math.max(res,prices[i]-minVal);
            minVal=Math.min(minVal,prices[i]);
        }
        return res;
    }
}
