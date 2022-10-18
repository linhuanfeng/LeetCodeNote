package 正则序列;
/**
 * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
 * 有一天小团得到了一个长度为n的任意序列s，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
 * 请问他最少用多少次操作可以把这个序列变成正则序列？
 * <p>
 * 进阶：时间复杂度O(n)\O(n) ，空间复杂度O(n)\O(n)
 * <p>
 * 将数组进行排序，输入序列第i位替换为正则序列第i位，那么就能保证总的改动次数最少
 */
/**
 * 将数组进行排序，输入序列第i位替换为正则序列第i位，那么就能保证总的改动次数最少
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine().trim()), ans = 0;
        int[] input = new int[n];
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            input[i] = Integer.valueOf(split[i]);
        }

        Arrays.sort(input);

        for (int i = 0; i < n; i++) {
            ans += Math.abs(input[i] - (i + 1));
        }
        System.out.println(ans);
    }
}