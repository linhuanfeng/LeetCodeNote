package a3.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口（双指针），map存窗口内的元素，
 *
 * 时间：O(n)每个元素最多进出map一次
 * 空间：O(n)map
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<2){
            return s.length();
        }
        Map<Character,Integer> map=new HashMap<>();
        int res=0,left=0;
        map.put(s.charAt(0),0);

        for (int i = 1; i < s.length(); i++) {
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
            }else {
                int before=map.get(c);
                res=Math.max(res,i-left);
                // 左指针右移
                for (int j = left; j <=before ; j++) {
                    map.remove(s.charAt(j));
                }
                left=before+1;
                map.put(c,i);
            }
        }
        res=Math.max(res,map.size());
        return res;
    }
}