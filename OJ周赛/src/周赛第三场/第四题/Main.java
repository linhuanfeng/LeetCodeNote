package 周赛第三场.第四题;

import java.io.*;
import java.util.Scanner;

public class Main {


    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/

        Scanner scanner = new Scanner(System.in);

        int num =scanner.nextInt();

        for (int i = 0; i < num; i++) {
            long j;
            long val =scanner.nextLong();
            if(val==1){
                System.out.println("No");
                continue;
            }
            boolean flag=true;
            for (j = 2; j <val; j++) {              //不需要算到i本身   只要算到 根号i  若仍没有能整除i的数 则i为素数
                if (val % j == 0){
                    flag=false;
                    break;                            //如果有j能整除i  则该数i 不是素数    break 结束内层循环
                }
            }
            if (flag){
                //从2到 根号i 都无法整除i  则是素数（质数）
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

        scanner.close();
    }
}

