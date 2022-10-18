package 将数组分裂成全1;

/**
 * 题目描述
 * 小红拿到了一个数组，她每次可以进行如下操作之一：
 * 选择一个元素x，将其分裂为1和x-1。
 * ·选择一个元素x，将其分裂为a和b，需要保证a*b=x
 * 小红希望用最少的操作次数，将所有数组的所有元素全部变成1。你能帮帮她吗？
 * 输入描述：
 * 第一行输入一个正整数n，代表数组的长度。
 * 第二行输入n个正整数ai，代表小红拿到的数组。
 * 1 ≤ n, ai ≤ 1e5
 * 输出描述：
 * 一个整数，代表最小的操作次数。
 *
 * input:
 * 2
 * 2 6
 *
 * output:
 * 5
 */

import java.util.Scanner;

/**
 * 思路：将输入的数组存成vec，同时将其中最大的元素bignum找出来，然后创建一个长度为bignum+1的dp数组，
 * 将0-bignum对应的需要拆分的最小次数以动态规划的方式从小到大全填上，
 * 然后遍历一遍vec每次从dp中找出对应的需要拆分的次数加上就行了。
 * 动态规划，找出dp[i]=max(dp[i-1]+1,dp[k1]+dp[k2]+1)
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),max=0;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
           a[i]=sc.nextInt();
           max=Math.max(max,a[i]);
        }
        int[] dp=new int[max+1];

        for (int i = 2; i <= max; i++) {
            dp[i]=dp[i-1]+1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i%j==0){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i/j]+1);
                }
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans+=dp[a[i]];
        }
        System.out.println(ans);
    }
}
