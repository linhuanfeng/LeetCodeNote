package 剑指Offer63.股票的最大利润;

/**
 * 算法：dp数组当前值前面的最小值dp[i]，则利润为prices[i]-dp[i],再用max记录当前的最大值
 * 时间复杂度：O(n)便利一遍数组为dp数组赋值
 * 空间复杂度：O(n)dp数组的开销
 */
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 1];
        dp[0]=Integer.MAX_VALUE;
        int max=0;
        for (int i = 1; i <= prices.length; i++) {
            if(dp[i-1]<prices[i-1]){
                dp[i]=dp[i-1];
                if(prices[i-1]-dp[i]>max){
                    max=prices[i-1]-dp[i];
                }
            }else{
                dp[i]=prices[i-1];
            }
        }
        return max;
    }
}