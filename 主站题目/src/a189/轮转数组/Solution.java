package a189.轮转数组;


/**
 * 源数组：            ----->-->
 * 先倒序             <--<-----
 * 0-k和k-len分别倒序  -->----->
 * 目标数组：          -->----->
 *
 *
 * 时间：O(n)
 * 空间：O(1)
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        // 先倒序
        reverse(nums, 0, nums.length - 1);
        k = k % nums.length;
        // 0-k和k-len分别倒序
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
