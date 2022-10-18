package a438.找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 滑动窗口,
 * 在方法一的基础上，我们不再分别统计滑动窗口和字符串 pp 中每种字母的数量，
 * 而是统计滑动窗口和字符串 pp 中每种字母数量的差；并引入变量 differ来记录
 * 当前窗口与字符串 pp 中数量不同的字母的个数，并在滑动窗口的过程中维护它。
 *
 * 在判断滑动窗口中每种字母的数量与字符串 pp 中每种字母的数量是否相同时，
 * 只需要判断 differ 是否为零即可。
 *
 * 时间：O(n)
 * 空间：O(k) 字母种类个数
 */
class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        int s_len=s.length(),p_len=p.length();

        if(s_len<p_len)
            return new ArrayList<>();

        int[] count=new int[26]; // 记录每个字母出现的个数
        int diff=0; // 记录不同的个数,如果改字母个数不同就加一，注意一种字母只会计数一次
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < p_len; i++) {
            count[s.charAt(i)-'a']++; // 如果每个位置出现的个数都是一样，那么count每个元素都是0
            count[p.charAt(i)-'a']--;
        }
        for (int coun : count) {
            if(coun!=0){ // count[i]不等于0，说明该元素个数不同
                diff++;
            }
        }
        if(diff==0)
            ans.add(0);
        // 下面有个细节，就是从i+1开始匹配，并且通过if(diff==0){}后移保证了i+p_len不越界
        for (int i = 0; i < s_len-p_len; i++) {
            // 窗口右移一位

            if(count[s.charAt(i)-'a']==1){ // 原窗口只多了一个，那么去掉就刚好，并且能对diff的值有影响
                diff--;
            }else if(count[s.charAt(i)-'a']==0){ // 本来该字母是刚好的，现在去掉该字母就从匹配变成不匹配
                diff++;
            }// 其它都对情况都对diff没有贡献
            count[s.charAt(i)-'a']--;

            if(count[s.charAt(i+p_len)-'a']==-1){ // 原窗口差一个，那么去掉就刚好，并且能对diff的值有影响
                diff--;
            }else if(count[s.charAt(i+p_len)-'a']==0){ // 本来该字母是刚好的，现在增加该字母就从匹配变成不匹配
                diff++;
            }// 其它都对情况都对diff没有贡献
            count[s.charAt(i+p_len)-'a']++;

            if(diff==0){ // 细节移到后面，不然i+p_len会越界
                ans.add(i);
            }
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