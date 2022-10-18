package 剑指Offer13.机器人的运动范围;

/**
 * 只能通过部分用例
 */
public class Solution {
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    public int movingCount(int m, int n, int k) {
        int total=0;
        boolean[][] visit = new boolean[m][n];
        boolean[][] res = new boolean[m][n];
        dfs(m,n,k,0,0,visit,res);
        for (boolean[] x:res) {
            for (boolean y:x){
                if(y){
                    total++;
                }
            }
        }
        return total;
    }
    void dfs(int m, int n, int k,int curX,int curY,boolean[][] visit,boolean[][] res){
        if(isValid(curX,curY,k)){
            // 不越界并且符合条件，添加到结果集
            res[curX][curY]=true;
        }
        for (int i = 0; i < 4; i++) {
            int tx=curX+dx[i];
            int ty=curY+dy[i];
            if(tx>=0&&tx<m&&ty>=0&&ty<n&&!visit[tx][ty]){
                visit[tx][ty]=true;
                dfs(m, n, k, tx, ty, visit, res);
                visit[tx][ty]=false;
            }
        }
    }
    boolean isValid(int x,int y,int k){
        int total=0;
        while (x!=0){
            total+=x%10;
            x/=10;
        }
        while (y!=0){
            total+=y%10;
            y/=10;
        }
        return total>k?false:true;
    }

    public static void main(String[] args) {
        int m=2,n=3,k=1;
        Solution solution = new Solution();
        System.out.println(solution.movingCount(m, n, k));
    }
}
