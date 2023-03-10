package a312.戳气球;

/**
 * dp
 * 1.定义状态：
 * 问什么就设什么，范围i,j,值就是所求的最值
 * 2.如何转移：
 * dp[i][j]表示开区间(i,j)能够得到的最大硬币数量
 * 给原气球左右两边各加一个temp[-1]=1，temp[n]=1,方便边界处理，但是不能戳破
 * 逆向思维：开始往i,j的中间加气球k，dp[i][j]=max(dp[i][k]+val[i]*val[k]*val[j]+dp[k][j]) i<j-1
 * dp[i][j]=0 i>=j-1
 * 假设 1 3 1 5 8 1
 * 插入8最大，dp[i][j]=val[i]*8*val[j]=8得  1 8 1
 * 分治，往i和8再插入3得 1 3 8 1
 * 插入5得  1 3 5 8 1
 * 插入1得  1 3 1 5 8 1
 * <p>
 * 因为k>i,k<j,所以要从左下角递推得到
 * <p>
 *   1 3 1 5 8 1
 *   0 1 2 3 4 5
 * 1 0 0 0
 * 3 1 0 0 0
 * 1 2 0 0 0 0
 * 5 3 0 0 0 0 0
 * 8 4 0 0 0 0 0 0
 * 1 5 0 0 0 0 0 0
 *
 * 时间：O(n^3)
 * 空间：O(n^2)
 */
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            temp[i] = nums[i - 1];
        }
        temp[0] = temp[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];

        for (int i = n + 1; i >= 0; i--) { // 左边界
            for (int j = i + 2; j <= n + 1; j++) { // 右边界
                for (int k = i+1; k < j; k++) { // 在i和j中加入获取金币最多的气球
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + temp[i] * temp[k] * temp[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3,1,5,8}));
    }
}
