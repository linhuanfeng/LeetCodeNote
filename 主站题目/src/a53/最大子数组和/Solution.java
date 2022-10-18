package a53.最大子数组和;

class Solution {
    public int maxSubArray(int[] nums) {
        // pre 记录以前一个数为后缀的最大和
        int pre=nums[0],ans=pre;
        for (int i = 1; i < nums.length; i++) {
            pre=Math.max(nums[i],pre+nums[i]);
            ans=Math.max(pre,ans);
        }
        return ans;
    }
}