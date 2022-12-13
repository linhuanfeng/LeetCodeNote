package a01背包2;

/**
 * dp[i][j] 表示前i个订单，预算为j能买到的最多股票数量
 *
 *     0  1  2
 * 0   0  0  0
 * 1,2 0  0  2
 * 2,2 0  0  0
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param order int整型二维数组 股票订单列表,order[0][0] 第一个订单的单价，order[0][1]第一个订单的股票数量
     * @param balance int整型 总预算
     * @return int整型
     */
    public int planStock (int[][] order, int balance) {
        // write code here
        int n=order.length;
        int[][] dp=new int[n+1][balance+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=balance ; j++) {
                dp[i][j]=dp[i-1][j]; // 不买
                int cost=order[i-1][0]*order[i-1][1];
                if(cost<=j){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-cost]+order[i-1][1]);
                }
            }
        }
        return dp[n][balance];
    }
}