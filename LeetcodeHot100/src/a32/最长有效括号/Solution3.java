package a32.最长有效括号;

/**
 * 动态规划
 *
 * 使用dp[i]表示以i结尾的的最长有效括号长度个数，
 * 当s[i]=')'时，且s[i-1]=')'，令i-dp[i-1]-1，判断s[t]是不是‘（’，不是则dp[i]=0，是则dp[i]=dp[i-1]+2+dp[t-1],(前提是不越界)
 * 当s[i]=')'时，且s[i-1]='(',则 dp[i]=dp[i-2]+2 (前提是不越界)
 * 否则=0
 * <p>
 *
 * ( ) )
 * 0 2 0
 * 0 1 2
 * <p>
 * ) ( ) ( )
 * 0 0 2 0 4
 * <p>
 * ) ( ) ( ) )
 * 0 0 2 0 4 0
 * <p>
 * ( ( ) ( ) )
 * 0 0 2 0 4 0
 * 0 1 2 3 4 5
 * <p>
 * <p>
 * <p>
 * ( ) ( ) ( ( ( ) ( ) ) )
 * 0 2 0 4 0 0 0 2 0 4 6
 * <p>
 * ( ) ( ) ) ) ) ) ( ) (   )  (
 * 0 2 0 4
 * 0 1 2 3 4 5 6 7 8 9 10 11 12
 * <p>
 *
 * 时间：O(n)
 * 空间：O(n)
 */
public class Solution3 {
    public int longestValidParentheses(String s) {
        int n = s.length(), res = 0;
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == ')') {
                    int t = i - dp[i - 1] - 1;
                    if (t >= 0 && s.charAt(t) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (t - 1 >= 0) {
                            dp[i] += dp[t - 1];
                        }
                    }
                } else {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().longestValidParentheses("()()))))()()("));
    }
}
