package a560.和为K的子数组;

/**
 * 时间：O(n^2)勉强通过
 * 空间：O(n)
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,ans=0;
        int[] preSum=new int[n];
        preSum[0]=nums[0];
        for (int i = 1; i <n ; i++) {
            preSum[i]=preSum[i-1]+nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t=preSum[j]-preSum[i]+nums[i];
                if(t==k){
                    ans++;
                }
            }
        }
        return ans;
    }
//    void dfs(int[] nums,int cur,int total,int k){
////        if(total==k){
////            ans++;
////        }
//        if(cur== nums.length){
//            return;
//        }
//        for (int i = cur; i < nums.length; i++) {
//            dfs(nums, i+1, total+nums[i],k);
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={-1,-1,1};
        System.out.println(solution.subarraySum(nums, 2));
    }
}