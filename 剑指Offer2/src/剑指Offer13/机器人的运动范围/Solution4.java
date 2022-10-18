package 剑指Offer13.机器人的运动范围;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 广度搜索
 * 时间复杂度：最坏情况，所有表格都便利一次，则O(n*m)
 * 空间复杂度：visit作为成员变量还是参数传递，力扣运行的时间和空间竟然一样
 */
public class Solution4 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visit=new boolean[m][n];
        int[] dx={0,1};
        int[] dy={1,0};
        Queue<int[]> queue=new LinkedList();
        int ans=1;

        visit[0][0]=true;
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int[] ints = queue.poll();
            int x=ints[0];
            int y=ints[1];
            for (int i = 0; i < 2; i++) {
                // 可达性：可以证明只向右或下就可以访问所有的表格
                int tx=x+dx[i];
                int ty=y+dy[i];
                if(tx<0||tx==m||ty<0||ty==n||!isValid(tx,ty,k)||visit[tx][ty]){
                    // 越界或者不符合条件，返回0
                    continue;
                }
                visit[tx][ty]=true;
                queue.offer(new int[]{tx,ty});
                ans++;
            }
        }
        return ans;
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
        int m=3,n=1,k=0;
        Solution4 solution = new Solution4();
        System.out.println(solution.movingCount(m, n, k));
    }
}
