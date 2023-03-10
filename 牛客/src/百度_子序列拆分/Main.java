package 百度_子序列拆分;

import java.io.*;
// 20
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]), k = Integer.parseInt(split[1]);
        int[] count = new int[k];
        long[] countValue = new long[k];

        String[] arr = br.readLine().split(" ");
        dfs(count, countValue, arr, 0, n);
        bw.write(ans + "");
        bw.flush();
    }

    static double ans = Double.MAX_VALUE;

    static void dfs(int[] count, long[] countValue, String[] arr, int cur, int n) {
        if (cur == n) {
            double t = 0;
            for (int i = 0; i < countValue.length; i++) {
                if (count[i] == 0) {
                    return;
                }
                t += countValue[i] / (count[i] * 1.0);
            }
            ans = Math.min(ans, t);
            return;
        }
        for (int i = 0; i < count.length; i++) {
            int temp = Integer.valueOf(arr[cur]);
            count[i]++;
            countValue[i] += temp;
            dfs(count, countValue, arr, cur + 1, n);
            count[i]--;
            countValue[i] -= temp;
        }
    }
}
