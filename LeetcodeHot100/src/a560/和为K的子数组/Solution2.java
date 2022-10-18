package a560.和为K的子数组;

/**
 * 枚举法:O（n^2）
 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            // 以当前i结尾的字串有多少个满足情况
            for (int j = i; j >= 0; j--) {
                temp += nums[j];
                if (temp == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums={-1,-1,1};
        System.out.println(solution2.subarraySum(nums, 0));
    }
}