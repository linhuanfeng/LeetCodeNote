package a63.不同路径II;

/*
动态规划
从右下到左上

时间：O(n*m)
空间：O（n*m）
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length,m=obstacleGrid[0].length;
        int[][] dp=new int[n+1][m+1];
        dp[n][m-1]=1; // 边界值处理

        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                if(obstacleGrid[i][j]==1){
                    continue;
                }
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}