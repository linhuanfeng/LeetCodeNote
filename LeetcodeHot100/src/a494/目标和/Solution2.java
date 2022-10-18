package a494.目标和;

/**
 * 不采用位运算
 *  时间：O(2^n)取决于递归的深度
 */
public class Solution2 {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(0,nums,target);
        return ans;
    }
    void dfs(int cur,int[] nums,int target){
        if(cur>=nums.length){
            if(target==0)ans++;
            return;
        }
        dfs(cur+1,nums,target-nums[cur]); // 正数的时候，就减少
        dfs(cur+1,nums,target+nums[cur]);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={1,1,1,1,1};
        int target=3;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}