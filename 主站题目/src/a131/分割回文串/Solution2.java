package a131.分割回文串;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 预处理所有dp[i][j]是否是回文串
 * <p>
 * dfs遍历所有情况
 */
public class Solution2 {
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        // 预处理所有dp[i][j]是否是回文串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true; // 一个字符串是回文串
            }
        }
        // 从左下到右上
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(dp, s, 0, new LinkedList<>());

        return res;
    }

    List<List<String>> res;

    void dfs(boolean[][] dp, String s, int left, Deque<String> list) {
        if (left == s.length()) {
            res.add(new ArrayList<>(list));
        }
        for (int i = left; i < s.length(); i++) {
            if (dp[left][i]) {
                list.add(s.substring(left, i + 1));
                dfs(dp, s, i + 1, list); // 当前取了
                list.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Solution2().partition("aab");
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
