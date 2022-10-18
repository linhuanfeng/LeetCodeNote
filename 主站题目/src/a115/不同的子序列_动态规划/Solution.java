package a115.不同的子序列_动态规划;

/*

使用dp[i][j]表示s中前i-1字符中子序列`t中前j个字符`出现的次数

如果 s[i-1]==t[j-1]
    dp[i][j]=保持不变dp[i-1][j-1]+
    或删除当前元素dp[i][j]=dp[i-1][j]
否则
    s删掉当前元素，即dp[i][j]=dp[i-1][j]

初始化，如果s和t都是0都是空串，那么有子序列出现次数为1
    如果s=0,t!=0，那么子序列出现次数为0
    如果s!=0,t=0，那么子序列出现次数为1

      r a b b i t
    0 1 2 3 4 5 6
  0 1 0 0 0 0 0 0
r 1 1 1 0 0 0 0 0
a 2 1 1 1 0 0 0 0
b 3 1 1 1 1 0 0 0
b 4 1 1 1 2 1 0 0
b 5 1 1 1 3 3 0 0
i 6 1 1 1 3 3 3 0
t 7 1 1 1 3 3 3 3

时间：O(nm)
空间：O（nm）

 */
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]; // 当前取或者不取
                } else {
                    dp[i][j] = dp[i - 1][j]; // 当前取不了
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDistinct("babgbag", "bag"));
    }
}