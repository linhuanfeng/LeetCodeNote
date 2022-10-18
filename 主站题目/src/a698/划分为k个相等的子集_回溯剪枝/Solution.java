package a698.划分为k个相等的子集_回溯剪枝;

import java.util.Arrays;

/**
 * 考虑回溯和剪枝
 * <p>
 * sum记作总和，tar=sum/k
 * 当然sum%k不整除直接返回false
 * 创建k个桶，每个球有k种选择，总共n个球，所以时间复杂度k^n
 * 尝试剪枝
 * 如果桶元素和大于tar,回溯
 * <p>
 * <p>
 * 回溯算法，每次把球放入
 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        int tar = sum / k;
        // 倒序排序增加剪枝的命中率，让值大的先选桶，那么桶元素和大于tar会更快满足
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while (i<j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
        return dfs(nums, new int[k], 0, tar);
    }

    /**
     * @param nums
     * @param buckets
     * @param index   第几个球
     * @param tar     每个桶的期望值
     */
    boolean dfs(int[] nums, int[] buckets, int index, int tar) {
        if (index == nums.length) {
        /*
         不需要再判断了，因为每个球都放完，肯定是满足条件的：
         首先每个桶之和小于等于tar
         其次，每个桶放完了，每个桶之和不能有小于tar的，如果小于tar说明有的大于tar,与上面矛盾
         因为所有桶之和要等于sum
         */
            // 球都分配完了，判断是否满足
//            for (int bucket : buckets) {
//                if(bucket!=tar){
//                    return false;
//                }
//            }
            return true;
        }
        for (int i = 0; i < buckets.length; i++) {
            if(i>0&&buckets[i]==buckets[i-1]){
                continue; // 和前一个桶之和一样，跳过，不然会重复计算
            }
            if (nums[index] + buckets[i] > tar) {
                continue; // 这个桶满了，找下一个
            }
            buckets[i] += nums[index];
            if (dfs(nums, buckets, index + 1, tar)) {
                return true;
            }
            buckets[i] -= nums[index]; // 撤销选择
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().
                canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 2));
    }
}