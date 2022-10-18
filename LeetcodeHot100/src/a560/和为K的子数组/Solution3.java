package a560.和为K的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和+hash
 * pre[i] 记作0-i的前缀和
 * 设pre[j,i]为k,则pre[i]-pre[j-1]=k
 * 移项得 pre[j-1]=pre[i]-k
 * 那么只需要找到满足以上条件的pre[j]就可以
 * 用一个map记录前缀和对应，前缀和为键，出现的次数为值
 */
class Solution3 {
    public int subarraySum(int[] nums, int k) {
        int ans = 0,pre=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int num : nums) {
            pre+=num; // pre记录当前的前缀和
            if(map.containsKey(pre-k)){ // 满足pre[i]-k的为以当前num结尾和k的自串
                ans+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 solution2 = new Solution3();
        int[] nums={-1,-1,1};
        System.out.println(solution2.subarraySum(nums, 0));
    }
}