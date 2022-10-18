package a45.跳跃游戏II;

import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = nums.length-2; i >=0 ; i--) {
            int t=nums[i];
            if(t==0){
                // 表示当前位置不能走步数
                continue;
            }
            // 防止数组越界
            t=(i+t>nums.length-1)?nums.length-i-1:t;
            for (int j = 1; j <=t ; j++) {
                dp[i]=Math.min(dp[i],dp[i+j]);
            }
            // 无法到达标记为max_val
            if(dp[i]!=Integer.MAX_VALUE){
                dp[i]++;
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(solution.jump(nums));
    }
}