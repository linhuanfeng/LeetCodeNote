package a200.岛屿数量;

/**
 * dfs
 * 时间：感觉不止O(n*m)
 * 空间：O(n*m)，vis数组
 */
class Solution {
    boolean[][] vis;
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    public int numIslands(char[][] grid) {
        vis=new boolean[grid.length][grid[0].length];
        int ans=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!vis[i][j]&&grid[i][j]=='1'){
                    vis[i][j]=true;
                    // 为访问过，且是陆地
                    dfs(i,j,grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    void dfs(int i,int j,char[][] grid){
        for (int k = 0; k <4 ; k++) {
            int tx=i+dx[k];
            int ty=j+dy[k];
            if(isOk(tx,ty,grid)){
                vis[tx][ty]=true;
                dfs(tx,ty,grid);
            }
        }
    }
    private boolean isOk(int tx, int ty,char[][] grid) {
        if(tx>=0&&tx<vis.length&&ty>=0&&ty<vis[0].length&&!vis[tx][ty]&&grid[tx][ty]=='1'){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid={{'1','1'},{'1',0}};
        System.out.println(solution.numIslands(grid));
    }
}