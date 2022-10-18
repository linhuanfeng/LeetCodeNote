package a139.单词拆分;

import java.util.*;

/**
 * 错误的解法：无法解决aaaaaaa aaa aaaa
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int n=s.length(),i=0;
        for (; i < n; i++) {
            int j=i+1,tag=0;
            for (; j <=n ; j++) {
                if(set.contains(s.substring(i,j))){
                    i=j-1; // 因为循环那里会j++,所以先减1
                    j++;
                    tag=1;
                    break;
                }
            }
            if(tag==0)return false;
        }
        return i==n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> dic=new ArrayList<>();
        dic.add("aaaa");
        dic.add("aaa");
        System.out.println(solution.wordBreak("aaaaaaa", dic));
    }
}