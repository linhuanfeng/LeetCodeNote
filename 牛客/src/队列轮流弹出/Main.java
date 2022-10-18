package 队列轮流弹出;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.valueOf(Integer.valueOf(br.readLine().trim()));
        int[] arr = new int[n];

        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }

        int left=0,right=n-1;
        boolean flag=true;
        while (left<=right){
            if(flag){ // 弹大的
                if(arr[left]>arr[right]){
                    bw.write(arr[left++]+" ");
                }else {
                    bw.write(arr[right--]+" ");
                }
            }else {
                if(arr[left]>arr[right]){
                    bw.write(arr[right--]+" ");
                }else {
                    bw.write(arr[left++]+" ");
                }
            }
            flag=!flag;
        }
        bw.flush();
    }
}
