package a44.通配符匹配_动态规划;

/**
 *
 * 使用dp[i][j]表示s的前i个字符和是p的前j个字符是否匹配
 *
 * 状态转移
 * 如果p[j]是小写字母，那么s[i]要精确匹配，且s的前i-1个字符和p的前j-1个字符也要匹配的
 * 是`?`号，s[i]一定匹配,那么结果等于s的前i-1个字符和p的前j-1个字符是否匹配
 * 是`*`号，s[i]一定匹配，且`*`可以0个或无数个，那么j可以取或不取，
 *              取dp[i-1][j]（由于`*`可以取多个，所以p[j]可以和s[i-1]继续匹配）||
 *              不取dp[i][j-1]（当前p[j]不取，那么s[i]和p[j-1]继续匹配）
 *
 * 边界值
 * s和p都是空串，匹配
 * 若s.length=0 只有p是`*`才可以进行匹配
 * 若p.length=0 肯定都不匹配
 *       * a * b
 *     0 1 2 3 4
 *   0 1 1 0 0 0
 * a 1 0 1 1 1 0
 * d 2 0 1 0 1 0
 * c 3 0
 * e 4 0
 * b 5 0
 *
 * 时间：O(nm)
 * 空间：O（nm）
 *
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;

        for (int j = 1; j <=m ; j++) {
            if(p.charAt(j-1)=='*'){
                dp[0][j]=dp[0][j-1]; // s是空字符串，只有p是`*`才可以进行匹配
            }
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                char c=p.charAt(j-1);
                if(c=='?'){
                    dp[i][j]=dp[i-1][j-1]; // `?`匹配任意单个字符，判断p[j-1]和s[i-1]是否匹配
                } else if (c=='*') {
                    dp[i][j]=dp[i-1][j]|| // 当前p[j]取,由于`*`可以取多个，所以p[j]可以和s[i-1]继续匹配
                            dp[i][j-1]; // 当前p[j]不取，那么s[i]和p[j-1]继续匹配
                }else {
                    dp[i][j]=c==s.charAt(i-1)&&dp[i-1][j-1]; // 字母精确匹配，当前p[j]和s[i]，p[j-1]和s[i-1]是否匹配都要匹配
                }
            }
        }
        return dp[n][m];
    }
}