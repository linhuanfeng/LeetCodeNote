package a169.多数元素;

import java.util.HashMap;
import java.util.Map;

/**
 * 投票算法：count记录候选人candidate的个数，如果当前数等于候选人，count+1,否则减一
 *  当count=0,candidate置为当前数
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution3 {
    public int majorityElement(int[] nums) {
        int candidate=0,count=0;
        for (int num : nums) {
            if(count==0)
                candidate=num;
            if(candidate==num)
                count++;
            else
                count--;
        }
        return candidate;
    }
}