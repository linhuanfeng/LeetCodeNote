package 剑指Offer21.调整数组顺序使奇数位于偶数前面;

public class Solution {
    public int[] exchange(int[] nums) {
        if(nums.length<=1){
            return nums;
        }
        // 左边第一个偶数
        int first_even=0;
        while (first_even<nums.length&&(nums[first_even]&1)!=0){
            // 找到第一个偶数
            first_even++;
        }
        if(first_even==nums.length){
            return nums;
        }
        for (int i = first_even+1; i < nums.length; i++) {
            if(nums[i]%2!=0){
                // 说明该数是奇数
                int temp=nums[first_even];
                nums[first_even]=nums[i];
                nums[i]=temp;
                first_even++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        Solution solution = new Solution();
        nums=solution.exchange(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
