package 剑指Offer5.最长回文子串;

/**
 * 时间复杂度：两个for循环，O（n2）
 * 空间复杂度：二维数组的开销O(n*n)
 */
public class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp=new boolean[s.length()+1][s.length()+1];
        char[] chars = s.toCharArray();
        int begin=1,maxLen=1;

        for (int i = 1; i <= s.length(); i++) {
            // 语义上设为true，实际上也会访问到吧
            dp[i][i]=true;
        }
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 1; i < j; i++) {
                if(chars[j-1]!=chars[i-1]){
                    dp[i][j]=false;
                }else {
                    if(j-i+1<=3){
                        // 没有子串或只剩下一个字符的字串
                        dp[i][j]=true;
                    }else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]&&j-i+1>maxLen){
                        begin=i;
                        maxLen=j-i+1;
                    }
                }
            }
        }
        return s.substring(begin-1,begin+maxLen-1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aacabdkacaa"));
    }
}
