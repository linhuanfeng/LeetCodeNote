package a300.最长递增子序列;

import java.util.Arrays;

/**
 * 使用数组dp[]保存以当前元素结尾的最大递增字串长度
 * 注意dp[i-1]不一定是保留着最大的字串个数
 *
 * 时间：O(n^2)
 * 空间：O(n)
 *
 * 进阶：时间复杂度O(nlogn)
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length,ans=1;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    // 找到可以加入自己的最长子序列,并更新dp数组
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}