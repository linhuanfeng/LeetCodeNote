package 剑指Offer19.正则表达式匹配;

/**
 * 使用f[i][j]表示s的前i个字符和p的前j个字符是否匹配
 * 当p[j]='*'时，
 *      ①s[i]=p[j-1]（包括p[j-1]=`.`）
 *          f[i][j]=f[i][j-2] 前面字符出现零个(丢弃组合'p[j-1]*')
 *          或f[i-1][j] 前面字符出现多个（等价于丢弃s[i]继续匹配，因为‘*’可以表示多个)
 *      ②s[i]!=p[j-1]
 *          f[i][j]=f[i][j-2] 前面字符出现零个(只能丢弃)
 *  当p[j]='.'时，匹配任意一个字符，f[i][j]=f[i-1][j-1]
 *  当p[j]=‘普通字符’时，f[i][j]=s[i]==p[j]&&f[i-1][j-1]
 *
 * 边界值
 *  dp[0][0]=1 s和p都是空串
 *  dp[0][j] 题目规定`*`前面都是有效字符，那么`*`取零个前面的才有机会匹配空串，出现`*`时j>1
 *  dp[i][0] s不是空串，p都是空串，那么都是0
 *
 *            b  a  *
 *         0  1  2  3
 *      0  1  0  0  0
 *  b   1  0  1  0  1
 *  a   2  0  0  1  1
 *  a   3  0  0  0  1
 *
 *            a  *
 *         0  1  2
 *      0  1  0  0
 *  a   1  0  1  0
 *  a   2  0  0  1
 *
 *            .  *
 *         0  1  2
 *      0  1  0  0
 *  a   1  0  1  0
 *  b   2  0  0  1
 *
 *  时间：O(nm) 两重循环
 *  空间：O(nm) dp数组
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int j=1;j<=m;j++){
            if(p.charAt(j-2)=='*'){
                dp[0][j]=dp[0][j-2]; // 当s为空串时，且p[j]='*'的特殊处理
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pj=p.charAt(j-1);
                if(pj=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){ // s[i]=p[j-1],不要漏掉`.`,`.`匹配任意字符
                        dp[i][j]=dp[i][j-2] // 前面字符出现0次
                                || dp[i-1][j]; // 前面字符出现多次（相当于丢弃s[i]继续和p[j]匹配）
                    }else {// s[i]!=p[j-1]只能前面字符匹配0次才有机会匹配成功
                        dp[i][j]=dp[i][j-2]; // 前面字符出现0次
                    }
                } else if (pj=='.') {
                    dp[i][j]=dp[i-1][j-1]; // 匹配任意字符
                }else {
                    dp[i][j]=(s.charAt(i-1)==p.charAt(j-1))&&dp[i-1][j-1]; // 当前字符和前一个匹配是否成功
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("aa", "a*"));
        System.out.println(new Solution().isMatch("ab", ".*"));
    }
}
