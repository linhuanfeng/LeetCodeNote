package a198.打家劫舍;

/**
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 */
class Solution2 {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==2)return Math.max(nums[0],nums[1]);
        // b2：前两个的最大值，b1：前一个的最大值
        int b2=nums[0],b1=Math.max(nums[0],nums[1]);
        int max=0;
        for (int i = 2; i < nums.length; i++) {
            // 当前位置的最大值
            max=Math.max(b2+nums[i],b1);
            b2=b1;
            b1=max;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={2,1,1,2};
        System.out.println(solution.rob(nums));
    }
}