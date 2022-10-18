package 周赛第三场.第二题;

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
        String str =cin.sval;

        str=str+"asdasdasdasdad";

        char[] chars = str.toCharArray();

        long res=1;

        for (int i = 0; i < chars.length-7; i++) {
            if(chars[i]>='0'&&chars[i]<='9'){
                String temp=chars[i]+"";
                int j;
                for (j = i+1; j <= i+5; j++) {
                    if(chars[j]>='0'&&chars[j]<='9'){
                        temp+=chars[j];
                    }else {
                        break;
                    }
                }
                i=j;
                Integer integer = Integer.valueOf(temp);
                res=res*integer;
            }
        }


        out.println(res);
        out.flush();// 关闭缓冲区
    }
}


