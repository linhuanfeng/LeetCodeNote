package a516.最长回文子序列_动态规划;

/**
 * 动态规划
 *
 * 使用dp[i][j]表示i到j的回文串最大长度
 *
 * 当s[i]==s[j],dp[i][j]=dp[i+1][j-1]+2
 * 当s[i]!=s[j],dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]) 没有贡献
 *
 * 那为什么当s[i]==s[j],不能是dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1])？
 * 比如abacca其结果是一样的
 * 对于aba,dp[i+1][j-1]+2得到的是更大的子序列
 *
 * 注意同样是从下到上，从左到右，保证子问题已被初始化
 *
 * 时间：O(n^2)
 * 空间：O(n^2)
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i]=1; // 单个字符串也是回文串
        }

        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
