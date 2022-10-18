package 剑指Offer59_I.滑动窗口的最大值;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 * 采用单调栈维护窗口的最大值
 *
 * 时间：O（n）
 * 空间：O（n）
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 非递增的栈
        Deque<Integer> que = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && que.getLast() < nums[i]) {
                que.removeLast();
            }
            que.addLast(nums[i]);
        }

        int index = 0;
        res[index++] = que.getFirst();

        for (int i = k; i < nums.length; i++) {
            if (que.getFirst() == nums[i - k]) {
                que.removeFirst();
            }
            while (!que.isEmpty() && que.getLast() < nums[i]) {
                que.removeLast();
            }
            que.addLast(nums[i]);
            res[index++] = que.getFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().
                maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}