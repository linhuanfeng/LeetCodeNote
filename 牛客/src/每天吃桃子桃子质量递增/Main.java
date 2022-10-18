package 每天吃桃子桃子质量递增;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),k=sc.nextInt(),x=sc.nextInt();
        int[] arr=new int[n];
        PriorityQueue<Integer> que=new PriorityQueue<>((a,b)->b-a);

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            que.add(arr[i]);
        }

        long total=0;
        for (int i = 0; i < k; i++) {
            while (!que.isEmpty()&&que.peek()>=x){
                total+=que.poll();
            }
            int[] t=new int[que.size()];
            int index=0;
            while (!que.isEmpty()){
                t[index++]=que.poll();
            }
            for (int i1 : t) {
                que.add(i1+1);
            }
        }
        System.out.println(total);
    }
}
