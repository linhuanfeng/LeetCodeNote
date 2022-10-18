package 周赛第一场.第四题;

import java.io.*;

public class Main {
    //加速读入
    static StreamTokenizer cin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int[] dp;

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        cin.nextToken();
        int n=(int)cin.nval;

        cin.nextToken();
        int k=(int)cin.nval;

        dp=new int[n+1];

        System.out.println(numWays(n));

//        out.println(a+b);
        out.flush();// 关闭缓冲区
    }
    public static int numWays(int n) {
        // 特殊情况，楼梯为0，情况1种
        if(n==0){
            return 1;
        }
        return doNum(n,9);
    }
    static int doNum(int n,int k){
        for (int i = 0; i < 3; i++) {
            dp[i]=i;
        }
        dp[1]=1;
        dp[2]=2;
        final int mod=1000000007;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]%mod+dp[i-2]%mod;
        }
        return dp[n];
    }
}
