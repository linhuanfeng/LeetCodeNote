package 修改K次数组求最小值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 贪心思想
 * 堆（优先级队列），每次改变价值最大的数
 *
 * 2 15
 * 2 4
 * 2 1
 *
 */
// 33
public class Main2 {
    public static void main(String[] args) throws IOException {
//        System.out.println(count1(15));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.valueOf(split[0]), k = Integer.valueOf(split[1]);
        int[] arr = new int[n];

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        String[] split2 = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(split2[i]);
            queue.add(arr[i]);
        }

        for (int i = 0; i < k; i++) {
            Integer max = queue.poll();
            queue.offer(calK(max,1));
        }
        int res=0;
        for (Integer integer : queue) {
            res+=integer;
        }
        System.out.println(res);
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
