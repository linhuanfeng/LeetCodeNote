package 数组分割差值最小_01背包问题;
//给一个整数数组 array，把他分为两部分 a 和 b，要使得 a 和 b 的元素之和的差最小。

/**
 * https://blog.csdn.net/shanshanhi/article/details/67639562
 *
 * 背包问题：从n个物品中取m个，求在不超过最大容量w下的最大价值。
 * 这道题就是求在容量mid下，能够取得的最大重量，因为最大容量只能mid,那等价于直接取最大值
 * 
 * 在容量为mid下，取得的最大值最接近mid，可以取得的最大值
 * 
 * 数组总和sum,一半mid=sum/2,转为01背包问题
 * 那么背包容量j=mid,求取得的价值dp[i][mid]小于等于mid且最大
 */
public class Main {
    int func(int[] nums){
        int n= nums.length,sum=0,mid;
        for (int num : nums) {
            sum+=num;
        }
        mid=sum/2;
        int[][] dp=new int[n+1][mid+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=mid ; j++) {
                if(nums[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return sum-dp[n][mid]-dp[n][mid];
    }

    public static void main(String[] args) {
        System.out.println(new Main().func(new int[]{5, 6, 8, 7}));
    }
}
