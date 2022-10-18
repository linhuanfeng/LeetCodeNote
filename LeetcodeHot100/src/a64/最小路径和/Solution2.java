package a64.最小路径和;

/**
 * 动态规划：找最优子问题
 * 动态规划，每个值，只跟上一个结点左边便结点有关，
 */
class Solution2 {
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i]+=grid[0][i-1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(j==0){
                    grid[i][j]+=grid[i-1][j];
                }else {
                    grid[i][j]+=Math.min(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(solution2.minPathSum(grid));
    }
}