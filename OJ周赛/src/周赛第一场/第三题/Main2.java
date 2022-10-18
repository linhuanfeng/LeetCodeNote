package 周赛第一场.第三题;

import java.io.*;
import java.util.HashMap;

public class Main2 {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        cin.nextToken();
        int n=(int)cin.nval;

        cin.nextToken();
        int m=(int)cin.nval;

        int[] arr=new int[n+1];

        for (int i = 0; i < m; i++) {
            cin.nextToken();
            int from=(int)cin.nval;

            cin.nextToken();
            int to=(int)cin.nval;

            for (int j = from; j <=to ; j++) {
                arr[j]++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(arr[i]==0){
                out.print(i+" ");
                out.print(0);
                out.flush();
                return;
            }
            if(arr[i]>1){
                out.print(i+" ");
                out.print(arr[i]);
                out.flush();
                return;
            }
        }

        out.println("YES");
        out.flush();// 关闭缓冲区
    }
}
