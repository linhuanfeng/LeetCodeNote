package a64.最小路径和;

/**
 * dfs超时
 */
class Solution {
    int min = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, grid[0][0]);
        return min;
    }

    void dfs(int[][] grid, int x, int y, int total) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            min = Math.min(min, total);
            return;
        }
        if (y + 1 < grid[0].length && total + grid[x][y + 1] < min) { // 剪枝
            dfs(grid, x, y + 1, total + grid[x][y + 1]);
        }
        if (x + 1 < grid.length && total + grid[x + 1][y] < min) { // 剪枝
            dfs(grid, x + 1, y, total + grid[x + 1][y]);
        }
    }
}