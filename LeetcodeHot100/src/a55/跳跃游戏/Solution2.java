package a55.跳跃游戏;

/**
 * 优化，用一个变量last标记该位置及之后能达到终点，如果最终last=0则结果为true
 * n-1一定可达，标记last=n-1
 * n-1+nums[n-1]>=last -->last=n-1  说明n-1这个位置也是可达的
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        int n=nums.length,last=n-1;
        for (int i = n-2; i >=0 ; i--)
            if(i+nums[i]>=last)
                last=i;
        return last==0;
    }
}