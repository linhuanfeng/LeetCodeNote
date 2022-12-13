package a1005.K次取反后最大化的数组和;

import java.util.PriorityQueue;

/**
 * 贪心+堆
 *
 * 每次对最小的取反，保证局部价值最大
 * 比如负数变正数
 * 整数变负数，也是小的整数变负数，损失最少
 *
 * 时间：O(nlogn)
 * 空间：O(n)
 */
class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        for (int i = 0; i < k; i++) {
            Integer min = queue.poll();
            queue.add(-min);
        }
        int res=0;
        for (Integer integer : queue) {
            res+=integer;
        }
        return res;
    }
}