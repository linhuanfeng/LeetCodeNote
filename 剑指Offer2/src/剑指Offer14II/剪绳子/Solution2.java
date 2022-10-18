package 剑指Offer14II.剪绳子;

/**
 * dp[i]=max(j*dp[j-i],j-i,dp[i])
 *
 * 时间：O(n^2)
 * 空间：O(n)
 */
public class Solution2 {
    public int cuttingRope(int n) {
        long[] dp = new long[n + 1];
        dp[0] =dp[1]= 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(dp[i], j * dp[i - j]),j*(i-j));
            }
        }
        return (int) (dp[n]%1000000007);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.cuttingRope(10));
    }
}
