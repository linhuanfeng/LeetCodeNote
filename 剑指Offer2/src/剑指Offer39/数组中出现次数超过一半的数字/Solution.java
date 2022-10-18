package 剑指Offer39.数组中出现次数超过一半的数字;

/**
 * 把出现最多的那个叫做众数
 * 假设当前为众数，+1，非众数-1
 * 若当前votes==0,则众数还在剩下的数中
 * 这是因为推论：
 *      所有的投票数一定大于1
 *      若当前票数之和等于0，则剩下的数投票之和一定大于1，则众数一定还在剩下的数中
 *
 */
class Solution {
    public int majorityElement(int[] nums) {
        int votes=0,x=nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(votes==0){
                x=nums[i];
                votes++;
                continue;
            }
            if(nums[i]==x){
                votes++;
            }else {
                votes--;
            }
        }
        return x;
    }

}