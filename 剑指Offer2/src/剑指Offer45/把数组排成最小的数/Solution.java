package 剑指Offer45.把数组排成最小的数;

/**
 * 冒泡排序
 */
public class Solution {
    public String minNumber(int[] nums) {
        for (int j=nums.length-1;j>0;j--){
            for (int i = 0; i < j; i++) {
                if((nums[i]+""+nums[i+1]).compareTo(nums[i+1]+""+nums[i])>0){
                    int t=nums[i];
                    nums[i]=nums[i+1];
                    nums[i+1]=t;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr={1,2,0};
        System.out.println(solution.minNumber(arr));
    }
}
