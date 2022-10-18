package 桃子装箱_最大数不超过n倍平均数;

import java.io.*;
import java.util.Arrays;

/**
 * 从小到大排序，计算最大的前缀和，left为左边界，不断维护left的
 * left不变，i+1,平均数会增加,最大值也会增加
 *
 * 时间：O(n^2)
 * 空间：O(1)
 */
// 100
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n=Integer.valueOf(s[0]),k=Integer.valueOf(s[1]);
        int[] arr=new int[n];
        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.valueOf(s[i]);
        }

        int left=0,max=0;
        long sum=0;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            while (arr[i]>k*sum*1.0/(i-left+1)){
                sum-=arr[left++]; // left右移，sum减去left对应的值
            }
            max=Math.max(max,i-left+1);
        }

        System.out.println(max);
    }
}
