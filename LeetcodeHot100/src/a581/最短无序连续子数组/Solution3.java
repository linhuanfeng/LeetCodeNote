package a581.最短无序连续子数组;

/**
 * 1,2,3,4
 * <p>
 * 为了使整个结果是升序数组，将数组分为左中右，满足中段的最大值小于等于右段的最小值，
 * 中段的最小值大于等于左段的最大值
 * <p>
 * 算法：从左到右遍历，维护最大值，如果当前值小于最大值，记录下标right，最终即为中段的右边界
 * 为什么？因为右段是严格递增的且所有数大于等于左边的最大值，即当前数nums[i]>前面的最大值max，
 * 如果不满足记录下标，就是中段右边界,记录下来
 * 从右向左遍历，同理
 */
public class Solution3 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[n - 1], left = 0, right = -1; // 中段不存在，则结果是0

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<max){
                // 不满足右段的规则
                right=i;
            }else {
                max=nums[i];
            }
            if(nums[n-i-1]>min){
                left=n-i-1;
            }else {
                min=nums[n-i-1];
            }
        }

        return right-left+1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().findUnsortedSubarray(
                new int[]{2,1}));
    }
}
