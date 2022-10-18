package 小红的踏前斩_01背包变体;

import java.io.*;

// 5
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(br.readLine());
        String[] split = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }

        dfs(arr,0,0);
        bw.write(min+" ");
        bw.flush();
    }

    static int min = Integer.MAX_VALUE;
    static void dfs(int[] arr,int cur,int cost){
        if(cur>arr.length-3){
            for (int i = 0; i < arr.length; i++) {
                cost+=arr[i];
            }
            min=Math.min(min,cost);
            return;
        }
        for (int i = cur; i <= arr.length - 3; i++) {
            if(arr[i]>=1&&arr[i+1]>=2&&arr[i+2]>=3){
                arr[i]--;
                arr[i+1]=arr[i+1]-2;
                arr[i+2]=arr[i+2]-3;
                dfs(arr, i, cost+5);
                arr[i]++;
                arr[i+1]=arr[i+1]+2;
                arr[i+2]=arr[i+2]+3;
            }else {
                dfs(arr, i+1, cost);
            }
        }
    }
}