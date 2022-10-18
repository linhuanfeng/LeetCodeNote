package a10.正则表达式匹配_动态规划;

/**
 *
 * 匹配前面的子表达式零次或多次。例如，zo* 能匹配 "z" 以及 "zoo"。* 等价于{0,}。
 *
 *
 * 使用dp[i][j]表示s的前i个字符是否和p的前j个字符匹配
 *
 * 如果是`*`号，可以匹配零个(说明可以让前一个元素消失)或多个前面的字符
 *      判断s[i]是否等于p[j-1]，如果相等：
 *                              匹配前面0个字符，dp[i][j-2] || // 匹配前面0个
 *                              匹配前面1个字符，dp[i-1][j] // 将s[i]扔掉，p[j]继续匹配
 *                           不相等：
 *                              只能匹配前面0个字符dp[i][j-2]
 *
 * 如果是`.`,可以匹配任意单个字符
 *      dp[i-1][j-1]
 *
 * 如果普通字符，那么那么精确匹配
 *      s[i]==p[j]&&dp[i-1][j-1]
 *
 * 边界值
 *  dp[0][0]=1 s和p都是空串
 *  dp[0][j] 题目规定`*`前面都是有效字符，那么`*`取零个前面的才有机会匹配空串
 *  dp[i][0] s不是空串，p都是空串，那么都是0
 *
 *
 *
 *       a *
 *     0 1 2
 *   0 1 0 0
 * a 1 0 1 1
 * a 2 0 0 1
 *
 *       . *
 *     0 1 2
 *   0 1 0 0
 * a 1 0 1 1
 * b 2 0 0 1
 *
 *       c * a * b
 *     0 1 2 3 4 5
 *   0 1 0 0 0 0 0
 * a 1 0 0 0 1 0 0
 * a 2 0 0 0 0 1 0
 * b 3 0 0 0 0 0 1
 *
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];

        dp[0][0]=true;
        for (int j = 1; j <= m; j++) {
            if(p.charAt(j-1)=='*') {
                dp[0][j] = dp[0][j - 2]; // `*`取零个前面的才有机会匹配空串
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=m ; j++) {
                char c=p.charAt(j-1);
                if(c=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j-2]|| // 匹配前面0个
                            dp[i-1][j]; // 匹配前面1个字符,扔掉s[i],p[j]继续和s[i-1]匹配
                    }else {
                        dp[i][j]=dp[i][j-2]; // 只能匹配前面0个，不然一定不相等
                    }
                } else if (c=='.') {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=s.charAt(i-1)==c&&dp[i-1][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().
                isMatch("aab", "c*a*b"));
    }
}