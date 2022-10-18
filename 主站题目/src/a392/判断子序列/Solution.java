package a392.判断子序列;

import java.util.Arrays;

/*
dp[i][j]表示s中前i个字符是否是t的前j个字符的子序列

if(s[i]==s[j])
    dp[i][j]=dp[i-1][j-1] 等于s中前i个字符是否是t中的前j个字符的子序列，j要取
else
    dp[i][j]=dp[i][j-1] 等于s中前i个字符是否是t中的前j-1个字符的子序列，j不取，判断j-1是否满足

dp[i][0]=0
dp[0][j]=1 s是空串，一定是t的子序列
dp[0][0]=1 空串是空串的子序列

时间：O(nm)
空间：O(nm)
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n + 1][m + 1];

        Arrays.fill(dp[0], true);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=dp[i][j-1]; // j当前不取
                }
            }
        }
        return dp[n][m];
    }
}