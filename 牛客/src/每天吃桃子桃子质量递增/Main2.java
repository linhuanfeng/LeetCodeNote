package 每天吃桃子桃子质量递增;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),k=sc.nextInt(),x=sc.nextInt();
        Integer[] arr=new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr,(a,b)->b-a);

        int left=0;
        long total=0;
        for (int i = 0; i < k; i++) {
            while (left<n&&arr[left]>=x){
                total+=arr[left++]+i;
            }
            x--;
        }
        System.out.println(total);
    }
}
