package 老张的美数课;

import java.io.*;

/**
 * 老张的美数课
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 老张教授开了一堂美数课！
 *
 * 老张认为每个非负整数x都有一个美丽值b(x)。
 *
 * 一个非负整数的美丽值定义为这个数十进制下每个数位的异或和。即，对于123来说，美丽值为1^2^3=0，
 * 对于654815424美丽值为6^5^4^8^1^5^4^2^4=9 （在C/C++中^运算符表示异或）
 *
 * 现在老张想考考同学，对于[L,R]这个闭区间内的所有整数，美丽值恰好为t的数有多少个。
 *
 *
 *
 * 输入描述
 * 第一行一个正整数，表示有次询问。
 *
 * 接下来有三行：
 *
 * 第一行个非负整数 L1,L2,...,Li,...,LT(1≤i≤T)
 *
 * 第二行个非负整数  R1,R2,...,Ri,...,RT(1≤i≤T)
 *
 * 第三行个非负整数  t1,t2,...,ti,...,tT(1≤i≤T)
 *
 * 每个询问是对于 [Li, Ri] (Li≤Ri)这个闭区间内的所有整数，美丽值恰好为的数有多少个。
 *
 *
 *
 * 输出描述
 * 每个询问输出T个整数，每两个数之间用空格隔开，表示答案。
 *
 *
 * 样例输入
 * 2
 * 0 1
 * 0 10
 * 0 1
 * 样例输出
 * 1 2
 *
 * 提示
 *
 *
 * 一共两次询问。
 *
 * 第1次询问 [0, 0] 这个区间中美丽值为0的有多少个，0的美丽值为0，答案为1。
 *
 * 第2次询问 [1, 10] 这个区间中美丽值为1的有多少个，1和10的美丽值为1，答案为2。
 */
// 64
public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.valueOf(br.readLine());
        int[] left = new int[t], right = new int[t], key = new int[t];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            left[i]=Integer.valueOf(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            right[i]=Integer.valueOf(s[i]);
        }
        s = br.readLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            key[i]=Integer.valueOf(s[i]);
        }

        for (int i = 0; i < t; i++) {
            long ans = 0;
            for (int j = left[i]; j <= right[i]; j++) {
                if (check(j, key[i])) {
                    ans++;
                }
            }
            bw.write(ans + " ");
        }
        bw.flush();
    }

    static boolean check(int k, int b) {
        if (k < 10) {
            return k == b;
        }
        int p = k % 10;
        k = k / 10;
        while (k > 0) {
            p = p ^ (k % 10);
            k = k / 10;
        }
        return p == b;
    }
}
