package a239.滑动窗口最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 优化：单调递减队列(只需保留窗口中较后的最大值，如果i存在，j肯定也存在，当nums[i]<=nums[j]，i可以舍弃，由j表示即可)
 *  假设i,j(i<j),且nums[i]<nums[j],那么i存在j一定存在，
 *      也就是i就不可能是最大值，所以舍弃i并由j来代替
 *  为什么是单调递减：如果非单调递减，那么前一个元素会被上一个条件舍弃
 *  每次插入的元素和队尾比较，如果大于等队尾，队尾元素弹出。
 *
 * 时间：O(n)： 遍历数组n,每个元素最多入队出队一次
 * 空间：O(n)：保留数组的所哟元素
 */
class Solution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>(); // 只需要记录下标即可,因为不需要堆的排序操作
        int[] arr = new int[nums.length - k+1];
        // 初始化第一个窗口
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) // 保证单调递减
                queue.pollLast();
            queue.offer(i);
        }
        arr[0] = nums[queue.peek()];

        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]) // 保证单调递减
                queue.pollLast();
            queue.offer(i);
            while (!queue.isEmpty()&&queue.peek() <= i - k) // 排除超出左边界的最大值
                queue.poll();
            arr[i-k+1] = nums[queue.peek()];
        }
        return arr;
    }

    public static void main(String[] args) {
        // [1,3,-1,-3,5,3,6,7]
        // 3
        // 1,-1 1
        Solution2 solution2 = new Solution2();
        int[] nums={1,-1};
        System.out.println(solution2.maxSlidingWindow(nums, 1));
    }
}