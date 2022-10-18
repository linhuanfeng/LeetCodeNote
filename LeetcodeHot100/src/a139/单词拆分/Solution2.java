package a139.单词拆分;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 动态规划
 * dp[k]&set.contains(s.substring(k,i))
 * 只要有一种情况可以满足字典构成即可
 *
 * for (int i = 1; i <= n; i++) {
 *             for (int k = 0; k <i ; k++) { // 只要有一种情况可以满足字典构成即可
 *                 // dp[i]=dp[j]&&check[j,i] ,j<=i
 *                 dp[i]=dp[k]&&set.contains(s.substring(k,i));
 *                 if(dp[i])break; // 只要有一种情况可以满足字典构成即可
 *             }
 *         }
 *
 *
 * 时间：O（n^2）
 * 空间：O(n)
 */
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        int n=s.length();
        boolean[] dp=new boolean[n+1]; // dp[i]表示前i子串是否能被字典组成
        dp[0]=true; // 边界值，设为true
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k <i ; k++) { // 只要有一种情况可以满足字典构成即可
                // dp[i]=dp[j]&&check[j,i] ,j<=i
                dp[i]=dp[k]&&set.contains(s.substring(k,i));
                if(dp[i])break; // 只要有一种情况可以满足字典构成即可
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<String> dic=new ArrayList<>();
        dic.add("leet");
        dic.add("code");
        System.out.println(solution.wordBreak("leetcode", dic));
    }
}