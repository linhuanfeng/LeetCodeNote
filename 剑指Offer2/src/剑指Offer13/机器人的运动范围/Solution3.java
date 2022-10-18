package 剑指Offer13.机器人的运动范围;

/**
 * DFS
 * 时间复杂度：最坏情况，所有表格都便利一次，则O(n*m)
 * 空间复杂度：visit作为成员变量还是参数传递，力扣运行的时间和空间竟然一样
 */
public class Solution3 {
    boolean[][] visit;
    public int movingCount(int m, int n, int k) {
        visit=new boolean[m][n];
        return dfs(m,n,k,0,0);
    }
    int dfs(int m, int n, int k,int curX,int curY){
        if(curX<0||curX==m||curY<0||curY==n||!isValid(curX,curY,k)||visit[curX][curY]){
            // 越界或者不符合条件，返回0
            return 0;
        }
        // 竟然这样子都是可以访问到的
        visit[curX][curY]=true;
        return 1+dfs(m, n, k, curX, curY+1)+
                dfs(m, n, k, curX+1, curY)+
                dfs(m, n, k, curX, curY-1)+
                dfs(m, n, k, curX-1, curY);
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
        Solution3 solution = new Solution3();
        System.out.println(solution.movingCount(m, n, k));
    }
}
