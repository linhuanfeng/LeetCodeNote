package 百度2020还原数列;

import java.util.PriorityQueue;
import java.util.Scanner;
public class Main {
    // 注意这个只能改变函数内的指针指向，调用者的指针并不会改变。但是如果改变地址的内容，那么调用者指向的内容也肯定会改变的
    public static void swap(PriorityQueue<Integer> heap1, PriorityQueue<Integer> heap2){
        PriorityQueue<Integer> t=heap1;
        heap1=heap2;
        heap2=t;
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        PriorityQueue<Long> heap1=new PriorityQueue<>((x,y)->{return y.compareTo(x);});
        PriorityQueue<Long> heap2=new PriorityQueue<>((x,y)->{return y.compareTo(x);});
        for (int i = 0; i < n; i++) {
            heap1.add(scan.nextLong());
        }
        long k=0;
        while(true){
            Long top=heap1.remove();
            if(top<n){
                break;
            }
            // 一次扩大步长，不然超时
            long step=top/n;
            heap2.add(top-n*step);
            while(!heap1.isEmpty()){
                Long t=heap1.remove();
                heap2.add(t+step);
            }
            PriorityQueue<Long> t=heap1;
            heap1=heap2;
            heap2=t;
            k+=step;
        }
        System.out.print(k);
        scan.close();
    }
}
