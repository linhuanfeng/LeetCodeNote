package 长度为k的重复字符字串;

import java.util.HashSet;
import java.util.Set;

/**
 * 用一个set保存每一个长度为k的子串，通过判断size是否小于k断定是否包含重复字串
 *
 * 时间：O(nk) hashSet基于hashMap实现，插入开销为O(1)
 * 空间：O（n） set的开销
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @param k int整型
     * @return int整型
     */
    public int numKLenSubstrRepeats (String s, int k) {
        // write code here
        int ans=0;
        Set<Character> set=new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            for (int j = 0; j < k; j++) {
                set.add(s.charAt(i+j));
            }
            if(set.size()<k){
                ans++;
            }
            set.clear();
        }
        return ans;
    }
}