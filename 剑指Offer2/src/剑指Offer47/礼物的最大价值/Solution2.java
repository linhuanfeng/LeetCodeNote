package 剑指Offer47.礼物的最大价值;

/**
 * 超时+1
 */
public class Solution2 {
    int dx[]={1,0};
    int dy[]={0,1};
    int max=0;
    public int maxValue(int[][] grid) {
        dfs(grid,0,0,grid[0][0]);
        return max;
    }
    void dfs(int[][] grid,int x,int y,int sum){
        if(x==grid.length-1&&y==grid[0].length-1){
            max=Math.max(max,sum);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int tx=x+dx[i];
            int ty=y+dy[i];
            if(tx<grid.length&&ty<grid[0].length){
                dfs(grid, tx, ty, sum+grid[tx][ty]);
            }
        }
    }
}
