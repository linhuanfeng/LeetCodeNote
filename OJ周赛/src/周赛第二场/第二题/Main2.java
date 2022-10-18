package 周赛第二场.第二题;

import java.io.*;

public class Main2 {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int res=Integer.MAX_VALUE;
    static int cities=0;
    static int[][] arr;

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

        vis[0]=true;
//        dfs(cities,0,0,vis);
        out.println(res);
        out.flush();// 关闭缓冲区
    }
        static int [] dijkstra(int weight[][],int start){
            int length = weight.length;//声明length来保存顶点个数
            int shortPath [] = new int[length];//保存到每个点的权重，也就是距离
            shortPath[0] = 0;
            int visited[] = new int[length];//标记已访问的点
            visited[0] = 1;
            for(int i = 1;i<length;i++){
                int k = -1;
                int d = Integer.MAX_VALUE;
                for(int i1 = 0 ;i1<length;i1++){
                    if(visited[i1]==0&weight[start][i1]<d){
                        d = weight[start][i1];
                        k = i1;
                    }
                }
                shortPath[k] = d;
                visited[k] = 1;
                for(int i2 = 0;i2<length;i2++){
                    if(visited[i2]==0&weight[start][k]+weight[k][i2]<weight[start][i2]){
                        weight[start][i2] = weight[start][k]+weight[k][i2];
                    }
                }
            }
            return shortPath;
        }
}
