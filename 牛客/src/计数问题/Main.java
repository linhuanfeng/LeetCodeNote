package 计数问题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static int n,x,ans=0;
    static Set<Integer> set=new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();

        // 求出多少位，每一位进行该数替换
        int c = 1, t = n;
        while (t != 0) {
            c++;
            t = t / 10;
        }

        int[] arr = new int[c];
        dfs(arr,0);
        System.out.println(ans);
    }
    static void dfs(int[] arr, int idx) {
        if (idx == arr.length) {
            int total = 0, weight = 1, count = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == x) { // 计数
                    count++;
                }
                total += arr[i] * weight;
                weight *= 10;
            }
            if (total <= n&&!set.contains(total)) { // 有效
                set.add(total);
                ans += count;
            }
            return;
        }
        dfs(arr,idx+1);
        arr[idx]=x;
        dfs(arr,idx+1);
        arr[idx]=0;

    }
    //        for (int i = ) {
//            arr[i] = x;
//            dfs(arr, i+1);
//            arr[i] = 0;
//        }
//    static void check(int[] arr){
//        int total = 0, weight = 1, count = 0;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] == x) { // 计数
//                count++;
//            }
//            total += arr[i] * weight;
//            weight *= 10;
//        }
//        if (total <= n) { // 有效
//            System.out.println(total);
//            ans += count;
//        }
//    }
}
