package 修改K次数组求最小值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 使用dp[i][j]表示前i个数，背包容量为j的序列之和的最小值
 * <p>
 *     0   1   2
 * 0   0   0   0
 * 8    1   8   1   1
 * 7    2   15  8   4
 * 1024 3  1039 16  9
 * <p>
 *    0  1  2
 * 0  0  0  0
 * 2  1  2  1
 * 15 2  17 6
 */
// 33
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(count1(15));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]), k = Integer.valueOf(split[1]);
        int[] arr = new int[n];

        String[] split2 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(split2[i]);
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i - 1]; // 初始化
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 当前数取0-j次
//                dp[i][j]=dp[i-1][j]+arr[i-1]; // 取0次
                for (int l = 0; l <= j; l++) {
                    int cal = calK(arr[i - 1], l);
                    dp[i][j] = Math.min(dp[i][j], cal + dp[i - 1][j - l]);
                }
            }
        }
        System.out.println(dp[n][k]);
    }

    static int calK(int a, int k) {
        if (k == 0) {
            return a;
        } else {
            return calK(count1(a), k - 1);
        }
    }

    static int count1(int a) {
        int total = 0, i = 0;
        while (a > 0) {
            if ((a & 1) == 1) {
                total++;
            }
            a = a >> 1;
        }
        return total;
    }
}
