package a31.下一个排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思想：1、每次尝试将左边较小的数和右边较大的数进行交换，能够保证字典序递增，
 * 2、同时，为了保证是下一个全排列，还得对i+1,n-1进行排序，保证刚好大于当前序列
 * <p>
 * 先对数组升序排列，然后每次从右向左找到第一个递增序列i，满足非递减序列nums[i]<nums[i+1],
 * 接着，从n-1到i+1找到第一个大于nums[i]的数进行交换，
 * 将i+1,n-1进行翻转，由于一定是递减序列，所以不需要排序，保证字典序刚好大于前一个序列
 * <p>
 * 时间：O(n)
 * 空间：O(n) 临时数组ans
 */
public class Solution2 {

    public void nextPermutation(int[] nums) {
        // write code here
        int n = nums.length, i, j;

        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            // 说明当前已经是最大的全排列了，退出循环
            reverse(nums,0,n-1);
            return;
        }
        for (j = n - 1; j > i; j--) {
            // 从i之后找到第一个大于i的数，进行交换
            if (nums[j] > nums[i]) {
                swap(nums,i,j);
                break;
            }
        }
        // 将i+1之后进行翻转，不需要排序，因为i+1到n一定是降序的
       reverse(nums,i+1,n-1);
    }

    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1,3,2};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}