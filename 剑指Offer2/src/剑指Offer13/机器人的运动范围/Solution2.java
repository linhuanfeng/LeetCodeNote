package 剑指Offer13.机器人的运动范围;

/**
 * DFS
 * 时间复杂度：最坏情况，所有表格都便利一次，则O(n*m)
 * 空间复杂度：visit二维数组的开销 O（n*m）
 *      为什么不用考虑递归栈的深度开销
 */
public class Solution2 {
    public int movingCount(int m, int n, int k) {
        return dfs(m,n,k,0,0,new boolean[m][n]);
    }
    int dfs(int m, int n, int k,int curX,int curY,boolean[][] visit){
        if(curX<0||curX==m||curY<0||curY==n||!isValid(curX,curY,k)||visit[curX][curY]){
            // 越界或者不符合条件，返回0
            return 0;
        }
        // 竟然这样子都是可以访问到的
        visit[curX][curY]=true;
        return 1+dfs(m, n, k, curX, curY+1, visit)+
                dfs(m, n, k, curX+1, curY, visit)+
                dfs(m, n, k, curX, curY-1, visit)+
                dfs(m, n, k, curX-1, curY, visit);
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
        int m=16,n=8,k=4;
        Solution2 solution = new Solution2();
        System.out.println(solution.movingCount(m, n, k));
    }
}
