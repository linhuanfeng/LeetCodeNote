package 周赛第三场.第一题;


import java.io.*;
import java.util.Scanner;

public class Main2 {

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        String[] arr={"January","February","March","April","May","June","July","August","September","October","November","December"};

        int index=-1;
        Scanner scanner = new Scanner(System.in);
        String mon = scanner.next();
        int num = scanner.nextInt();

        for (int i = 0; i < 12; i++) {
            if(mon.equals(arr[i])){
                index=i+1;
                break;
            }
        }

        System.out.println(arr[(num+index)%12-1]);
        scanner.close();
    }
}

