package a494.目标和;

/**
 * pos记作所有正号之和，neg记作所有负号之和
 * pos-neg=(total-neg)-neg=target,所以neg=(total-target)/2 ，所以只要找出和为neg的方案数即可
 * 又因为neg是非负数，所以total-target>=0;且被2整除
 *
 *
 * 当没有任何元素可以选取时，元素和只能是 0，对应的方案数是 1，因此动态规划的边界条件是：
 * dp[0][j]={
 *      1,   j=0
 *      0,   j≥1
 *
 * 当 1≤i≤n 时，对于数组 nums 中的第i个元素num（ii 的计数从 11 开始），遍历 0≤j≤neg，计算 dp[i][j] 的值：
 * 如果 j<num，则不能选 num，此时有 dp[i][j]=dp[i−1][j]；
 * 如果 j≥num，则如果不选 num，方案数是 dp[i−1][j]，如果选 num，方案数是 dp[i−1][j−num]，此时有 dp[i−1][j]+dp[i−1][j−num]。
 *
 * 因此状态转移方程如下：
 * dp[i][j]={
 *      dp[i−1][j],                       j<nums[i]
 *      dp[i−1][j]+dp[i−1][j−nums[i]],    j≥nums[i]  当前数num要取保证j>=num,因为num>j的话，前i个数的和就不可能等于j
 * 两个状态合并，dp[i][j]=dp[i-1][j],如果j>=nums[i],dp[i][j]+=dp[i-1][j] ​
 *
 * 最终得到 dp[n][neg] 的值即为答案。
 */
public class Solution3 {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length,total=0,neg=0;
        for (int num : nums) {
            total+=num;
        }
        if(total<target||(total-target)%2!=0)return 0; // 排除不满足条件的数，解释见开头
        neg=(total-target)/2;

        int[][] dp=new int[n+1][neg+1]; // dp[i][j]表示前i位和为j的方案数
        dp[0][0]=1; // neg=0即都不取，也算一种情况
        for (int i = 1; i <= n; i++) {
            int num=nums[i-1]; // 当前位置的值
            for (int j = 0; j <= neg; j++) { // 计算当前位置，计算和为j的方案数
                dp[i][j]=dp[i-1][j]; // j是否>=num都要取，表示当前位置不加入的方案数
                if(j>=num){ // 当前位置可以加入，那么就等于前一个位置neg为j-num的方案数   因为前一个位置neg为j-num,那么加上当前才会等于j
                    dp[i][j]+=dp[i-1][j-num];
                }
            }
        }
        return dp[n][neg];
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums={1000};
        int target=-1000;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}