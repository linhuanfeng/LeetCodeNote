package 剑指Offer21.调整数组顺序使奇数位于偶数前面;

public class Solution2 {
    public int[] exchange(int[] nums) {
        // a&1==0 和 a%2==0 等价
        int i=0,j=nums.length-1;
        while (i<j){
            while (i<j&&(nums[i]&1)!=0){
                // 左指针找到偶数
                i++;
            }
            while (i<j&&(nums[j]&1)!=1){
                // 左指针找到偶数
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        Solution2 solution = new Solution2();
        nums=solution.exchange(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
