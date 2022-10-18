package 公司食堂;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 使用三个小顶堆，分别存座位人数tb2，tb1和tb0，使用桌子号作为关键字保证最左优先
 * 对于男士来说，先找tb1的，找到就把桌子移到tb2中，否则从tb0中找
 *
 * 时间：mlogn 人数m,堆插入维持平衡需要logn
 * 空间：o(m)
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.valueOf(br.readLine());
        for (int i = 0; i < t; i++) {
            PriorityQueue<Integer> heap0 = new PriorityQueue<>();
            PriorityQueue<Integer> heap1 = new PriorityQueue<>();
            PriorityQueue<Integer> heap2 = new PriorityQueue<>();

            int n = Integer.valueOf(br.readLine()); // 座位个数
            String table = br.readLine(); // 座位落座情况
            int m = Integer.valueOf(br.readLine()); // 人数
            String people = br.readLine(); // 排队的人

            for (int j = 0; j < n; j++) {
                switch (table.charAt(j) - '0') {
                    case 0:
                        heap0.add(j);
                        break;
                    case 1:
                        heap1.add(j);
                        break;
                    case 2:
                        heap2.add(j);
                        break;
                }
            }

            int[] ans = new int[m];
            for (int a = 0; a < m; a++) {
                if (people.charAt(a) == 'M') {
                    if (!heap1.isEmpty()) {
                        Integer poll = heap1.poll();
                        heap2.add(poll);
                        ans[a] = poll+1;
                    } else {
                        Integer poll = heap0.poll();
                        heap1.add(poll);
                        ans[a] = poll+1;
                    }
                } else {
                    if (!heap0.isEmpty()) {
                        Integer poll = heap0.poll();
                        heap1.add(poll);
                        ans[a] = poll+1;
                    } else {
                        Integer poll = heap1.poll();
                        heap2.add(poll);
                        ans[a] = poll+1;
                    }
                }
            }
            for (int an : ans) {
                bw.write(an);
                bw.newLine();
            }
        }
        bw.flush();
    }
}