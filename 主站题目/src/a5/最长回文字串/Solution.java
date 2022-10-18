package a5.最长回文字串;

/**
 * 动态规划
 * s[i]==[j]是的话，判断dp[i+1][j-1](左下角)是不是，否则一定不是
 * 所以从下往上，从左往右或从右往左都可以
 * 时间：O(n^2)
 * 空间：O(n^2)
 */
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j]=true; // 相等的或i>j的视为回文串,考虑了aa或aba情况
            }
        }
        int left=0,right=0,max=1;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]){
                        dp[i][j]=true; // i，j是回文串
                        if(j-i+1>max){
                            left=i;
                            right=j;
                            max=j-i+1;
                        }
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
}