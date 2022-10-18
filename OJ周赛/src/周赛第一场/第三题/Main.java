package 周赛第一场.第三题;

import java.io.*;
import java.util.HashMap;

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

        cin.nextToken();
        int m=(int)cin.nval;

        HashMap<Integer, Integer> map = new HashMap<>();

        int minDayMuch=-1;

        for (int i = 0; i < m; i++) {
            cin.nextToken();
            int from=(int)cin.nval;

            cin.nextToken();
            int to=(int)cin.nval;

            for (int j = from; j <=to ; j++) {
                int temp=map.getOrDefault(j,-1);
                if(temp!=-1){
                    // 说明已经有了
                    map.put(j,1);
                }else {
                    // 记录最小多加水
                    if(minDayMuch==-1){
                        minDayMuch=i;
                    }
                    map.put(j,temp+1);
                }
            }
        }


        
//        out.println(a+b);
        out.flush();// 关闭缓冲区
    }
}
