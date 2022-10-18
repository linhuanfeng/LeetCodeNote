package 周赛第二场.第二题;

import java.io.*;

public class Main3 {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int res=Integer.MAX_VALUE;
    static int cities=0;
    static int[][] edge;
    static int[] vis;
    static int[] type={0,1,3};

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        cin.nextToken();
        cities=(int)cin.nval;

        edge=new int[cities][cities];

        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                cin.nextToken();
                edge[i][j]=(int)cin.nval;
            }
        }

        vis=new int[cities];

        for (int i = 0; i < cities; i++) {
            vis[i]=1;
            dfs(1,i,0);
            vis[i]=0;
        }
        out.println(res);
        out.flush();// 关闭缓冲区
    }

    public static void dfs(int num,int cur, int dis) {
        /**
         * 如果当前路径大于之前找到的最小值，可直接返回
         * */
        if (dis > res) {
            return;
        }
        /**
         * 判断是否达到最后一个结点，更新最小值，返回
         * */
        if(num == cities) {
            if (type[0]!=0&&type[2]!=0&&dis < res) {
                res = dis;
                return;
            }
        }
        /**
         * 当前点到其他各点之间可连通但是还未添加进来时，遍历执行
         * */
        for (int i = 0; i < cities; i++) {
            if (vis[i] == 0) {
                for (int j = 0; j < 3; j++) {
                    type[j]++;
                    vis[i] = 1;
                    dfs(num+1,i, dis+type[i]*edge[cur][i]);
                    /**
                     * 回溯
                     **/
                    type[j]--;
                    vis[i] = 0;
                }
            }
        }
        return;
    }
}
