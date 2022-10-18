package a322.零钱兑换;

/**
 * 子问题：F(s)=F(s-c)+1,f(s)表示构成金额为s的最小硬币数
 * dp[i]=min(dp[i-coins[0]],dp[i-coins[j]])+1,最后一个硬币是coins[0],coins[1]等
 * 时间：O（sn） s表示amount总额，n表示面额的数目
 * 空间：O（n）
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        for (int i = 1; i <=amount ; i++) {
            for (int coin : coins) {
                if(coin<=i&&dp[i-coin]!=Integer.MAX_VALUE){
                    // 如果dp[i-coin]=Integer.MAX_VALUE说明没有该面值的硬币
                    dp[i]=Math.min(dp[i-coin]+1,dp[i]);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins={1,2,5};
        int target=11;
        System.out.println(solution.coinChange(coins, target));
    }
}