package a16.最接近的三数之和;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE,ans=-1;
        for (int i = 0; i <= nums.length - 3; i++) {
            if(i!=0&&nums[i]==nums[i-1])break;
            int left=i+1,right= nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right]; // 当前三数和
                int t=Math.abs(target-sum); // 差值
                if(t<min){
                    min=t;
                    ans=sum;
                }
                if(sum<target){
                    // 移到下一个不相等的数
                    while (left<right&&nums[++left]==nums[left-1]);
                } else if (sum > target) {
                    // 移到下一个不相等的数
                    while (left<right&&nums[--right]==nums[right+1]);
                }else {
                    return target;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(
                new int[]{-1,2,1,-4}, 1));
    }
}
