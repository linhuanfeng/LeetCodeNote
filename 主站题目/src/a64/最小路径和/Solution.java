package a64.最小路径和;

class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length-2; i >=0; i--) {
            // 最后一列
            grid[i][grid[0].length-1]+=grid[i+1][grid[0].length-1];
        }

        for (int j = grid[0].length-2; j >=0 ; j--) {
            grid[grid.length-1][j]+=grid[grid.length-1][j+1];
        }

        for (int i = grid.length-2; i >=0; i--) {
            for (int j = grid[0].length-2; j >=0 ; j--) {
                grid[i][j]+=Math.min(grid[i+1][j],grid[i][j+1]);
            }
        }
        return grid[0][0];
    }
}