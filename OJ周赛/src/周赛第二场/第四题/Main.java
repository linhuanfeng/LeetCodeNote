package 周赛第二场.第四题;

import java.io.*;

public class Main {
    //    加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static String arr="abcdefghijklmnopqrstuvwxyz";
    static long t=0;

    public static void main(String[] args) throws IOException {
        cin.nextToken();
        int n=(int)cin.nval;
        dfs(n,0,"");
        out.println(t%20211121);
        out.flush();
    }
    static void dfs(int n,int cur,String res){
        if(n==0){
            t++;
            t=t%20211121;
            return;
        }
        for (int i = cur; i < 26; i++) {
            dfs(n-1,i,res+arr.charAt(i));
        }
    }
}

