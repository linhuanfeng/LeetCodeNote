package a560.和为K的子数组;

/**
 * 错误解法
 * 尝试双指针:
 * 因为有可能是负数，比如-1，-1，1那么我们就无法确定了指针的移动方向
 * 双指针的关键就是要知道指针能怎么移动
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,i=0,j=0,ans=0,count=0;
        while (i<n){
            count+=nums[j];
            if(count==k){
                ans++;
                count-=nums[i];
                i++;
                j++;
            }else if(count<k){
                j++;
            }else {
                count-=nums[i];
                count-=nums[j]; // 因为开头会再算一次
                i++;
            }
        }
        return ans;
    }
}