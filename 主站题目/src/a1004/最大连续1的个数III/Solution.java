package a1004.最大连续1的个数III;

/**
 * 题目：给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 滑动窗口：转为：找出最大的窗口，最多允许k个0
 * 时间：O(n) 遍历一遍，窗口左移一步不算进去
 * 空间：O(1)
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0, left = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            if (count > k) {
                while (left < nums.length && nums[left++] != 0) ; // 0的个数大于k了，窗口左边移除第一个0
                count--;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}