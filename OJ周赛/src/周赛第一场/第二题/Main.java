package 周赛第一场.第二题;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
//        System.out.println(n);

        cin.nextToken();
        int k=(int)cin.nval;

        TreeSet<Integer> set=new TreeSet<>();


        for (int i = 2; i <= n; i++) {
            int j;
            for (j = 2; j <= Math.sqrt(i); j++) {              //不需要算到i本身   只要算到 根号i  若仍没有能整除i的数 则i为素数
                if (i % j == 0) break;                            //如果有j能整除i  则该数i 不是素数    break 结束内层循环
            }
            if (j > Math.sqrt(i)){
                //从2到 根号i 都无法整除i  则是素数（质数）
                set.add(i);
//                System.out.println(j);
            }
        }

//        for (Integer integer : set) {
//            System.out.print(integer+" ");
//        }
//        System.out.println();

        Integer[] arr=new Integer[set.size()];
        set.toArray(arr);
//        for (Integer integer : arr) {
//            System.out.print(integer+" ");
//        }


        int res=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(set.contains(arr[i]+arr[i+1]+1)){
                res++;
            }
        }

        if(res==k){
            out.println("Yes");
        }else {
            out.println("No");
        }

//        out.println(res);
        out.flush();// 关闭缓冲区
    }
}
