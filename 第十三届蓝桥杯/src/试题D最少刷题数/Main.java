package 试题D最少刷题数;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums=new int[N];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            nums[i]=sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            int more=0,less=0;
            for (int j = 0; j < N; j++) {
                if(i!=j){
                    if(nums[j]>nums[i]){
                        heap.add(nums[j]);
                        more++;
                    }
                    if(nums[j]<nums[i])less++;
                }
            }
            int t=more-less>0?more-less:0; // 相差几个人
            if(t==0){
                System.out.print(t+" ");
            }else {
                int last=0;
                for (int j = 1; j <=(t+1)/2 ; j++) {
                    last=heap.poll();
                }
                System.out.print(last-nums[i]+1+" ");
            }
            heap.clear();
        }
        sc.close();
    }
}
