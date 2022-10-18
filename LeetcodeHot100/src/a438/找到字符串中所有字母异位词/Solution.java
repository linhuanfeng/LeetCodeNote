package a438.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口,用数组存判断是否是异位词
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int s_len=s.length(),p_len=p.length();
        if(s_len<p_len)return new ArrayList<>();
        int[] tar=new int[26],vis=new int[26];
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < p_len; i++) {
            tar[p.charAt(i)-'a']++;
        }
        for (int i = 0; i < p_len; i++) {
            vis[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <= s_len-p_len; i++) {
            if(Arrays.equals(tar,vis)){
                ans.add(i);
            }
            // 窗口右移一位
            vis[s.charAt(i)-'a']--;
            if(i+p_len>=s_len)break;
            vis[s.charAt(i+p_len)-'a']++;
        }
        return ans;
    }

    private boolean isYiweiCi(int[] tar, int[] vis) {
        for (int i = 0; i < tar.length; i++) {
            if(tar[i]!=vis[i])return false;
        }
        return true;
    }
}