package 最长不重复字串;


import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口或双指针
 * 使用map保存窗口中出现的值
 */
public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return int整型
     */
    public int lengthOfLongestSubstring (String s) {
        if(s==null|| s.length()==0){
            return 0;
        }
        // write code here
        int left=0,right=left+1,ans=1;
//        int[] arr=new int[26];
        Map<Character,String> map=new HashMap<>();

        map.put(s.charAt(0),"");
        while (right<s.length()){
            char c=s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c,"");
            }else {
                ans=Math.max(ans,right-left);
                while (s.charAt(left)!=c){
                    // 找到那一个相同的数
                    map.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            right++;
        }
        ans=Math.max(ans,right-left);
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}