package a238.除自身以外数组的乘积;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] ans = new int[n];
        int pre = 1;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            pre = pre*nums[i-1];
            ans[i] = pre;
        }
        pre=1;
        for (int i = n-2; i >=0 ; i--) {
            pre*=nums[i+1];
            ans[i]*=pre;
        }
        return ans;
    }
}