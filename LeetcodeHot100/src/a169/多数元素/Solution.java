package a169.多数元素;

import java.util.HashMap;
import java.util.Map;

/**
 * map
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int half=nums.length/2;
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if(count+1>half)
                return num;
            map.put(num,count+1);
        }
        return -1;
    }
}