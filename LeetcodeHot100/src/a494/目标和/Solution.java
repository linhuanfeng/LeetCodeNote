package a494.目标和;

/**
 * 我这样用位运算超时了
 * 原因分析：递归2^n加上递归出口还要nums.length的循环
 *
 */
public class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(0,0,nums,target);
        return ans;
    }
    void dfs(int cur,int state,int[] nums,int target){
        if(cur>=nums.length){
            // 判断是否符合
            int total=0;
            for (int i = 0; i < nums.length; i++) {
                if((state>>i&1)>0){ // 位为1表示相加
                    total+=nums[i];
                }
                else{
                    total-=nums[i];
                }
            }
            if(total==target)ans++;
            return;
        }
        for (int i = 0; i < 2; i++) {
            if(i==0){
                // 当前位置为0
                if((state>>cur&1)>0){
                    // cur位是1，要置为0
                    dfs(cur+1,state^1<<cur,nums,target);
                }else {
                    // 本来就为0不用操作
                    dfs(cur+1,state,nums,target);
                }
            }else{
                // 当前位置为1
                dfs(cur+1,state|1<<cur,nums,target);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={1};
        int target=1;
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}