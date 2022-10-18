package 周赛第二场.第一题;

import java.io.*;

public class Main {
//    加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        cin.nextToken();
        String t = cin.sval;
        String s="hello";
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index < 0) {
                out.println("NO");
                out.flush();// 关闭缓冲区
                return;
            }
        }
        out.println("YES");
        out.flush();
    }
}
