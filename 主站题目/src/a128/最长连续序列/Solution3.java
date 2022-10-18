package a128.最长连续序列;

import java.util.Arrays;
// ac但不满足，但时间是O（nlogn）
public class Solution3 {
    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Arrays.sort(nums);

        int left, right;
        left = right = nums[0];
        int count = 1, index = left;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
            } else if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else { // 不满足连续递增
                if (count > right - left + 1) {
                    left = index;
                    right = nums[i - 1];
                }
                // 计数和下标重新计数
                index = nums[i];
                count = 1;
            }
        }
        if (index != nums[nums.length - 1]) {
            if (count > right - left + 1) {
                left = index;
                right = nums[nums.length - 1];
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().longestConsecutive(
                new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3}));
    }
}
