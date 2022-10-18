package a416.分割等和子集_01背包问题;

/**
 * 转为01背包问题
 *
 * 定义dp[i][j]为前i个商品得到价值为j的个数(注意正常背包问题表示价值)
 *
 * dp[0][0]=1  前0个商品价值为0，满足，所以个数设为1
 * dp[i][j]=dp[i-1][j]+dp[i-1][j-val[j]]
 * 因次，转为求价值为mid(sum/2)的元素个数是否大于1，只要满足一种就说明可以成功分割
 *
 *
 * 如果和为奇数，一定无法分割
 *
 *
 *  0 1 2 3 4 5 6 7 mid
 * 0
 * 1
 * 2
 * 3
 */
public class Solution2 {
    public boolean canPartition(int[] nums) {
        int n=nums.length,total=0;

        for (int num : nums) {
            total+=num;
        }
        if(total%2!=0)return false;
        int mid=total/2;

        long[][] dp=new long[n+1][mid+1];

        dp[0][0]=1;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <= mid; j++) {
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
            if(dp[i][mid]>0){ // 有一个满足即可，提前结束，不然累加和会越界
                return true;
            }
        }
        return dp[n][mid]>0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100}));
    }
}
