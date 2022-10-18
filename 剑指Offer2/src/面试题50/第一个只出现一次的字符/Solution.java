package 面试题50.第一个只出现一次的字符;

class Solution {
    public char firstUniqChar(String s) {
        int[] letters = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            letters[chars[i]-'a']++;
        }
        for (char c : chars) {
            if(letters[c-'a']==1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("leetcode"));
    }
}