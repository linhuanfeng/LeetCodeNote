package a647.回文子串;

/**
 * 采用中心扩展法
 * 中心扩展，遍历所有可能的中心，然后向两边扩展
 *  * 奇数，那么中间是一个数，偶数，中间是两个数
 * 时间：O(n^2)
 * 空间：O(1)
 */
public class Solution2 {
    int ans = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            centerExtend(s, i, i);
            centerExtend(s, i, i + 1);
        }
        return ans;
    }

    void centerExtend(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            ans++;
            i--;
            j++;
        }
    }
}
