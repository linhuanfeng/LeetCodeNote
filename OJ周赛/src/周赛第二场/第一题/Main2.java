package 周赛第二场.第一题;

import java.io.*;

public class Main2 {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        cin.nextToken();
        String source = cin.sval;

//        out.println(source);
//        if (source)

        int i=0,j=0;
        String target="hello";

        while (i<source.length()&&j<target.length()){
            if(source.charAt(i)==target.charAt(j)){
                i++;
                j++;
            }else {
                i++;
            }
        }

        if(j>=target.length()){
            out.println("YES");
            out.flush();// 关闭缓冲区
            return;
        }

        out.println("NO");
        out.flush();// 关闭缓冲区
    }
}
