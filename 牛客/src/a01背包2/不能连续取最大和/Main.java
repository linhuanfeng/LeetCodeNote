package a01背包2.不能连续取最大和;

/**
 * 入门dp
 * dp[i][j]表示前i个取1或0的最大值
 *
 * dp[i][0]=max(dp[i-1][0],dp[i-1][1])
 * dp[i][1]=dp[i-1][0]+nums[i]
 *
 */
public class Main {
    public static int maxSum(int[] nums){
        int n= nums.length,max=Integer.MIN_VALUE;
        int[][] dp=new int[n][n];
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1]=dp[i-1][0]+nums[i];
            max=Math.max(max,Math.max(dp[i][0],dp[i][1]));
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(Main.maxSum(new int[]{ 3,4,5,8,10,15}));
    }
}
