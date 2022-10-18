package 剑指Offer40.最小的k个数;

import java.util.PriorityQueue;

/**
 * 小跟堆：时间反而更长
 */
public class Solution2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->(Integer.compare(a,b)));
        for (int i : arr) {
            queue.add(i);
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={3,2,1};
        Solution2 solution = new Solution2();
        for (int item : solution.getLeastNumbers(arr, 2)) {
            System.out.print(item+" ");
        }
    }
}
