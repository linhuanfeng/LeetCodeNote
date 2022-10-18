package 不重复的全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思想：1、每次尝试将左边较小的数和右边较大的数进行交换，能够保证字典序递增，
 *      2、同时，为了保证是下一个全排列，还得对i+1,n-1进行排序，保证刚好大于当前序列
 *
 * 先对数组升序排列，然后每次从右向左找到第一个递增序列i，满足nums[i]<nums[i+1],
 * 接着，从n-1到i+1找到第一个大于nums[i]的数进行交换，
 * 将i+1,n-1进行升序排列，保证字典序刚好大于前一个序列
 *
 * 时间：O(n^2)
 * 空间：O(n) 临时数组ans
 */
public class Solution2 {

    public int[][] UniquePerm (int[] nums) {
        // write code here
        int n=nums.length,i,j;
        List<int[]> ans=new ArrayList<>();

        Arrays.sort(nums); // 先排序得到最小的字典序
        ans.add(Arrays.copyOf(nums,n));
        while (true){
            for (i = n-2; i >=0 ; i--) {
                if(nums[i]<nums[i+1]){
                    break;
                }
            }
            if(i<0){
                // 说明当前已经是最大的全排列了，退出循环
                break;
            }
            for (j = n-1; j >i ; j--) {
                // 从i之后找到第一个大于i的数，进行交换
                if(nums[j]>nums[i]){
                    swap(nums,i,j);
                    break;
                }
            }
            // 将i+1之后进行翻转，不需要排序，因为i+1到n一定是降序的
            reverse(nums,i+1,n-1);
            ans.add(Arrays.copyOf(nums,n));
        }
        return ans.toArray(new int[ans.size()][]);
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
        for (int[] ints : solution.UniquePerm(new int[]{3, 3, 4})) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}