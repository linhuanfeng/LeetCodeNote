package 周赛第三场.第三题;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/

        Scanner scanner = new Scanner(System.in);

        double l =scanner.nextDouble();
        double r =scanner.nextDouble();

//        long r =scanner.nextLong();

        int k =scanner.nextInt();

        boolean flag=false;

        int i=0;

        while (true){
            double pow = Math.pow(k, i++);
            if(pow>r){
                break;
            }
            if(pow>=l){
                flag=true;
                String temp = String.valueOf(pow);
                System.out.print(temp.substring(0,temp.indexOf("."))+" ");
            }
        }

//        for (long i = l; i <= r; i++) {
//            if(i%k==0||i==1){
//                flag=true;
//                System.out.print(i+" ");
//            }
//        }

        if(!flag){
            System.out.println("-1");
        }

        scanner.close();
    }
}

