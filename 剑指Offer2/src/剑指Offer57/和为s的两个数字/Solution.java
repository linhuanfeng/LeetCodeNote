package 剑指Offer57.和为s的两个数字;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1,t=0;
        while (i<=j){
            t=nums[i]+nums[j];
            if(t==target){
                return new int[]{nums[i],nums[j]};
            }else if(t>target){
                j--;
            }else {
                i++;
            }
        }
        return null;
    }
}