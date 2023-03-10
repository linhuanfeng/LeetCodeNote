package a673.最长递增子序列的个数;

import java.util.Arrays;

/**
 * {@link a334}
 * 使用len[i]表示以nums[i]结尾的最长递增子序列的长度，
 * cnt[i]表示以nums[i]结尾的最长递增子序列的个数
 * maxLen表示最长递增子序列的长度
 * 因此当len[i]=maxLen就是答案数列
 * <p>
 * 时间：O(n^2) 两重循环
 * 空间：O(n) dp辅助数组
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 1, // 最长递增子序列的长度
                ans = 1;
        int[] len = new int[n], // 最长递增子序列的长度
                cnt = new int[n]; // 最长递增子序列的个数

        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int t = len[j] + 1;
                    if (t > len[i]) { // 大于当前子序列的最大长度，更新
                        len[i] = t;
                        cnt[i] = cnt[j]; // 共享前一个子序列的数量
                    } else if (t == len[i]) { // 重置计数
                        cnt[i]+=cnt[j]; // 得到相同长度的最长子序列，因此数量加一
                    }
                }
            }
            if (len[i] > maxLen) { // 大于子序列的最大长度，更新
                maxLen = len[i];
                ans = cnt[i]; // 数量使用cnt[i]进行替换
            } else if (len[i] == maxLen) {
                ans+=cnt[i]; // 长度等于最大子序列长度，答案个数加一
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1,1,1,2,2,2,3,3,3}));
    }
}
