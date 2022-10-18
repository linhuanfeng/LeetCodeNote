package a221.最大正方形;

/**
 * 0 1 1 1 0
 * 1 1 1 1 0
 * 0 1 1 1 1
 * 0 1 1 1 1
 * 0 0 1 1 1
 *
 * 0 1 1 1 0
 * 1 1 2 2 0
 * 0 1 2 3 1
 * 0 1 2 3 2
 * 0 0 1 2 3
 *
*                 if(matrix[i][j]=='0')
*                     dp[i][j]=0;
*                 else { // 只有dp[i-1][j],dp[i][j-1],dp[i-1][j-1])的正方形数都是相等的时候，说明当前结点可以加入，最小值都一样，否则也是最小的值+1，以为
*                     dp[i][j]=Math.min(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]))+1;
*                 }
 *
 *
 *
 * 见 https://leetcode.cn/problems/count-square-submatrices-with-all-ones/solution/tong-ji-quan-wei-1-de-zheng-fang-xing-zi-ju-zhen-2/
 * 时间:O(mn）
 */
class Solution2 {
    public int maximalSquare(char[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        int ans=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1'){
                    if(i==0||j==0) // i=1或j=1时以i,j为右下角的正方形面积一定为1
                        dp[i][j]=1;
                    else { // 只有dp[i-1][j],dp[i][j-1],dp[i-1][j-1])的正方形数都是相等的时候，说明当前结点可以加入，最小值都一样，否则也是最小的值+1
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}