package a239.滑动窗口最大值;

import java.util.PriorityQueue;

/**
 * 优先级队列（大顶堆）
 * 为了判断堆顶元素是否还在窗口中，可以存入一个二元组（value,index）
 * <p>
 * 时间：O(nlogn)： 遍历数组n,堆插入的调整是logn
 * 空间：O(n)：保留数组的所哟元素
 */
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>( // 大根堆，并让索引越小的更大
                (a, b) -> b[0] != a[0] ? b[0] - a[0] : a[1]-b[1]);
        int[] arr = new int[nums.length - k+1];
        // 初始化第一个窗口
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        arr[0] = queue.peek()[0];

        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i], i});
            while (queue.peek()[1] <= i - k) // 排除超出左边界的最大值
                queue.poll();
            arr[i-k+1] = queue.peek()[0];
        }
        return arr;
    }
}