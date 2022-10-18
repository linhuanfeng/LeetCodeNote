package 周赛第一场;

import java.io.*;

public class Main {
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

        int range=1;
        int ming=0;
        for (int j = 0; j < 5; j++) {
            cin.nextToken();
            ming+=(int)cin.nval;
        }

        for (int i = 1; i < n; i++) {
            int total=0;
            for (int j = 0; j < 5; j++) {
                cin.nextToken();
                total+=(int)cin.nval;
            }
            if(total>ming){
                range++;
            }
        }

//        cin.nextToken();
//        int b=(int)cin.nval;

        out.println(range);
        out.flush();// 关闭缓冲区
    }
}

