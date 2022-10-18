package 输入输出测试;

import java.util.PriorityQueue;
import java.util.Scanner;
public class HasNextPlus {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        while(scan.hasNext("\n")){
            scan.nextInt();
        }
        scan.close();
    }
}