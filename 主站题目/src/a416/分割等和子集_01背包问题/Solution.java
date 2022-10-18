package a416.分割等和子集_01背包问题;

/**
 * 转为01背包问题
 * 定义dp[i][j]为前i个商品得到价值为j的个数(注意正常背包问题表示价值)
 *
 * 记数组元素总和为total,那么只需要找出和为total/2的数即可
 * 因此，背包重量j就为total/2,找出前i个背包中是否有价值total/2的情况，有即可满足条件
 *
 * 注意total%2必须等于0
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for (int num : nums) {
            total+=num;
        }
        if(total%2!=0)return false; //一定得是2整除才可能分割
        int tar=total/2,n=nums.length;
        // 接下来就转换成0，1背包问题，找到一个子集为tar的即可
        int[][] dp=new int[n][tar+1]; // dp[i][j]表示前i个数中和为j的个数
        dp[0][0]=1; // 子集为0个数为1（即都不取）
        for (int i = 1; i < nums.length; i++) {
            int num=nums[i-1]; // 当前数记为num
            for (int j = 0; j <= tar; j++) { // 遍历为当前位置对应的j赋值
                dp[i][j]=dp[i-1][j]; // 当前数取与不取都要，都包括前一个位置的方案数
                if(j>=num){ // 说明当前数可以取，那么前一个位置的和就是j-num,因此加上dp[i-1][j-num]的个数
                    dp[i][j]+=dp[i-1][j-num];
                }
            }
            if(dp[i][tar]>0)return true; // 找到一个即可
        }
        return false;
    }
}