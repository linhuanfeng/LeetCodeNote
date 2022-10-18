package 周赛第二场.第二题;

import java.io.*;

public class Main {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int res=Integer.MAX_VALUE;
    static int cities=0;
    static int[][] arr;
    static int[] cost={0,1,3};
    static int[] type={0,0,0};

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        cin.nextToken();
        cities=(int)cin.nval;

        arr=new int[cities][cities];

        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < cities; j++) {
                cin.nextToken();
                arr[i][j]=(int)cin.nval;
            }
        }

        boolean[] vis=new boolean[cities];

        for (int i = 0; i < cities; i++) {
            vis[i]=true;
            dfs(cities,0,0,vis);
        }

        out.println(res);
        out.flush();// 关闭缓冲区
    }
    static void dfs(int n,int sum,int cur,boolean vis[]){
        if(sum>res){
            // 剪枝
            return;
        }
        if(n==1){
            if(type[0]!=0&&type[2]!=0&&sum<res){
                res=sum;
            }
            return;
        }

        for (int j = 0; j < cities; j++) {
            if(!vis[j]){
                for (int i = 0; i < 3; i++) {
                    vis[j]=true;
                    type[i]++;
                    dfs(n-1,sum+cost[i]*arr[cur][j],j,vis);
                    vis[j]=false;
                    type[i]--;
                }
            }
        }
    }
}
