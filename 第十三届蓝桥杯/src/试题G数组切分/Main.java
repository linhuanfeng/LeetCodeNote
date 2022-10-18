package 试题G数组切分;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] nums=new int[N],dp=new int[N+1];
        for (int i = 0; i < N; i++) {
            nums[i]=sc.nextInt();
        }
        dp[0]=dp[1]=1;
        for (int i = 1; i < N; i++) {
            dp[i+1]+=dp[i]; // dp[1]表示第一位的个数
            for (int j = 0; j < i; j++) {
                if(dp[j]!=0&&isOk(j,i,nums)){
                    dp[i+1]++;
                }
            }
        }
        System.out.println(dp[N]);
        sc.close();
    }

    private static boolean isOk(int i, int j,int[] nums) {
        int len=j-i+1;
        int[] ints = new int[len];
        System.arraycopy(nums,i,ints,0,len);
        Arrays.sort(ints);
        for (int k = 1; k <len ; k++) {
            if(ints[k]-ints[k-1]!=1)return false;
        }
        return true;
    }
}
