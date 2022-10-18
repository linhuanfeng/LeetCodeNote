package 值和下标之和都不是指数;

import java.util.Scanner;
/*
第一题的话，需要考虑到
1. 奇+奇 = 偶
2. 偶 + 偶 = 偶数
所以我们只需要尽量将奇数放在奇数下标，偶数防在偶数下标就可以了。
再考虑到2是偶数，但是是质数。需要将1，2单独考虑就可以了。
 */
// ac
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String res = fun(n);
        System.out.println(res);
    }

    private static String fun(int n) {
        if (n <= 2) {
            return "-1"; // 1 2都是不存在
        }
        // [1, n]
        StringBuilder builder = new StringBuilder();
        int end = n - ((n + 1) % 2); // 得到最大的奇数，奇数还是本身，偶数就减一，奇数加一一定是合数
        for (int i = end; i >= 1; i --) {
            builder.append(i).append(" "); // 奇+奇=偶，偶+偶=偶数，所以一定是非质数
        }
        if (n % 2 == 0) { // 偶数就最后加上自己
            builder.append(n).append(" ");
        }
        return builder.toString();
    }
}

