package a560.和为K的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+哈希表
 *
 * 使用pre[i]表示[j,i]的前缀和
 * 要找到子数组和等于k,等价于找到j满足pre[i]-pre[j-1]=k,
 * 移项得，pre[j-1]=pre[i]-k，也就是找到前缀和为pre[i]-k的个数。
 * 使用map存储前缀和出现的次数，就能O(1)获取pre[i]-k出现的个数
 * 从左向右遍历，维护map，保证了j<=i
 *
 * 总结：找到pre[i]-pre[j-1]=k即为要找的子数组，转为找前缀和等于pre[i]-k出现的次数
 *      使用map存储前缀和出现的次数
 *
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution2 {
    public int subarraySum(int[] nums, int k) {
        int preSum=0,ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1); //

        for (int i = 0; i <nums.length ; i++) {
            preSum+=nums[i]; // 当前的前缀和
            ans+=map.getOrDefault(preSum-k,0); // 找到前缀和满足=pre[i]-k的前缀和数目
            map.put(preSum,map.getOrDefault(preSum,0)+1); // 更新map，细节点：这句得放在后面，
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={1};
        System.out.println(solution.subarraySum(nums, 0));
    }
}