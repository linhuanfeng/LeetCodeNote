package 值和下标之和都不是指数;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
// 70
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        vis=new boolean[n];
        int[] arr=new int[n];
        dfs(0,arr,n);
        if(!tag){
            System.out.println(-1);
        }
    }

    static boolean[] vis;
    static boolean tag=false;
    static void dfs(int index, int[] arr, int n) throws IOException {
        if(tag){
            return;
        }
        if(index==n){
            tag=true;
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i : arr) {
                bw.write(i+" ");
            }
            bw.flush();
            return;
        }
        for (int j = 0; j < n; j++) { // 取值
            if(tag){
                return;
            }
            if (!vis[j] && !isZhiShu(index+1 + j + 1)) {
                vis[j]=true;
                arr[index] = j + 1;
                dfs(index + 1, arr, n);
                vis[j]=false;
            }
        }
    }
    static boolean isZhiShu(int i) {
        for (int j = 2; j <= Math.sqrt(i * 1.0); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
