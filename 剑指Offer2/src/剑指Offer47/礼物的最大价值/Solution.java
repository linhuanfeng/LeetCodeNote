package 剑指Offer47.礼物的最大价值;

/**
 * 超时
 */
public class Solution {
    public int maxValue(int[][] grid) {
        return dfs(grid,0,0,grid[0][0]);
    }
    int dfs(int[][] grid,int x,int y,int sum){
        if(x==grid.length-1&&y==grid[0].length-1){
            return sum;
        }

        int a=0;
        if(x+1<grid.length){
            a=dfs(grid,x+1,y,sum+grid[x+1][y]);
        }
        int b=0;
        if(y+1<grid[0].length){
            b=dfs(grid,x,y+1,sum+grid[x][y+1]);
        }
        return a>b?a:b;
    }
}
