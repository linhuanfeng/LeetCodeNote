package 两个有序数组间相加的topk问题;

import java.io.*;
import java.util.*;

/**
 * 5 4
 * 1 2 3 4 5  数组1
 * 3 5 7 9 11 数组2
 * <p>
 * 使用Set+大根堆
 * set存放使用过的组合，防止重复使用
 * <p>
 * 堆的元素为：Node(a1,a2,sum) 为了让下一次遍历知道从哪里开始，即从(a1-1,a2)或(a1,a2-1)开始
 *
 * 时间：O(klogk)，k个数，每次加入堆，元素维护需要logk
 * 空间：O(n)堆临时存放元素
 */
public class Main {
    static class Node {
        int a1;
        int a2;
        int sum;

        public Node(int a1, int a2, int sum) {
            this.a1 = a1;
            this.a2 = a2;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        // 测试用例会有格式转换异常
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] split = br.readLine().split(" ");
//        int n = Integer.valueOf(split[0]), k = Integer.valueOf(split[1]);
//        int[] a1 = new int[n];
//        int[] a2 = new int[n];
//        split = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            a1[i] = Integer.valueOf(split[i]);
//        }
//
//        split = br.readLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            a2[i] = Integer.valueOf(split[i]);
//        }

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Integer[] a1 = new Integer[n];
        Integer[] a2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            a1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a2[i] = in.nextInt();
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        Set<String> positionSet = new HashSet<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> b.sum - a.sum);

        positionSet.add((n-1) + "_" + (n-1));
        heap.add(new Node(n-1, n-1, a1[n-1] + a2[n-1]));

        int[] ans = new int[k];
        int count = 0;
        while (count < k) {
            Node poll = heap.poll();
            ans[count++] = poll.sum;
            int i1 = poll.a1;
            int i2 = poll.a2;
            if (i1 - 1 >= 0 && !positionSet.contains(i1-1+"_"+i2)) { // 每次从最大的下标进行试探，保证topk
                positionSet.add(i1-1+"_"+i2);
                heap.add(new Node(i1-1,i2,a1[i1-1]+a2[i2]));
            }
            if (i2 - 1 >= 0 && !positionSet.contains(i1+"_"+(i2-1))) {
                positionSet.add(i1+"_"+(i2-1));
                heap.add(new Node(i1,i2-1,a1[i1]+a2[i2-1]));
            }
        }
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
}
