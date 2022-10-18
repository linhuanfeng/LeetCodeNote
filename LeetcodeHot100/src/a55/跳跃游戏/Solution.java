package a55.跳跃游戏;

class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] dp=new boolean[n];
        dp[n-1]=true;
        for (int i = n-2; i >=0 ; i--) {
            for (int j = 1; j <=nums[i] ; j++) {
                if(i+j<n&&dp[i+j]){
                    // 只要有一个位置能到达终点就行
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0];
    }
}