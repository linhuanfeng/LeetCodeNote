package a322.零钱兑换;


/**
 * 记忆化搜索
 *
 * 比如6  [1 2 3]
 * 我们记f(s)表示金额为s最少需要的硬币数，通过递归树发现很多重复了
 * 那么使用count[s]来保存子问题的最优解，即记忆化搜索
 *
 *                 6
 *        5          4      3
 *     4 3    2    3 2 1   2 1 0
 *   321 210 10   21 1 0  10 0
 *
 *  时间：O(Sn),本来是S^n，但是由于记忆化count[S]记忆化只被计算一次，所以复杂度是Sn
 *  空间：O(s),额外数组保存计算出来的答案f(s)
 */
public class Solution3 {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins,amount,new int[amount+1]);
    }

    public int coinChange(int[] coins, int remain,int[] count) {
        if(remain<0){
            return -1; // 不能整取
        }
        if(remain==0){
            return 0;
        }

        if(count[remain]!=0){ // 记忆化，如果已经搜索过，直接返回
            return count[remain];
        }

        int min=Integer.MAX_VALUE;
        for (int coin : coins) {
            if(coin<=remain){
                int res = coinChange(coins, remain - coin, count);
                if(res>=0){
                    min=Math.min(min,res+1);
                }
            }
        }
        count[remain]=min== Integer.MAX_VALUE?-1:min;
        return count[remain];
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().coinChange(
                new int[]{1, 2, 3}, 6));
    }
}
