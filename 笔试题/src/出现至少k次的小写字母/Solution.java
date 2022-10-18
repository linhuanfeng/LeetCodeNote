package 出现至少k次的小写字母;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param S string字符串 
     * @param k int整型 
     * @return int整型
     */
    public int howMany (String S, int k) {
        // write code here
        int[] letters = new int[26];
        for (int i = 0; i < S.length(); i++) {
            letters[S.charAt(i)-'a']++;
        }
        int ans=0;
        for (int i=0;i<26 ; i++) {
            if(letters[i]>=k){
                ans++;
            }
        }
        return ans;
    }
}