package a55.跳跃游戏;

/**
 * 使用贪心法
 * 每次维护最大能到达的地方last,如果last到达n-1那么提前结束
 * 如果当前i>last,说明不能到达当前i,返回false
 */
class Solution3 {
    public boolean canJump(int[] nums) {
        int n=nums.length,last=0;
        for (int i = 0; i <n&&last<n-1 ; i++){
            if(i>last)return false; // 说明从0开始当前位置已经不可达了，更不说终点了
            last=Math.max(last,i+nums[i]); // 更新最多能到达的地方
        }
        return true;
    }
}