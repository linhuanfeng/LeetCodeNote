package a424.替换后的最长重复字符;

/**
 * 使用maxn记录历史出现次数最多的的字符串history_max_char，只有当前字符串是history_max_char，那么才可能会对最终的长度有所贡献
 * 使用左右指针i,j表示左右窗口的边界，如果j-i+1>maxn+k,左右指针同时移动，否则，移动右指针，最终j-i就是结果
 * 注意，窗口中的非最大重复字串的数目可能大于k，但是对结果不会影响：
 * 如果j-i+1>maxn+k，说明当前字串不能满足，所以左右指针右移，总体长度不变，因此不会对结果产生影响，也就不用管当前字串是否满足条件
 *
 * 整个窗口只增不减
 * <p>
 * 时间：O(n)
 * 空间：O(A)
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int maxn = 1, i = 0, j = 0;
        int[] arr = new int[26];
        while (j < s.length()) {
            int idx = s.charAt(j) - 'A';
            arr[idx]++;
            maxn = Math.max(maxn, arr[idx]); // 记录最大重复字串出现的次数
            if (j - i + 1 > maxn + k) { // 说明当前窗口不能满足条件了，那么整体右移
                arr[s.charAt(i)-'A']--; // 频次减少
                i++;
            }
            j++;
        }
        return j - i; // 只增不减，所以结果一定是最大的长度
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("BAAA", 0));
    }
}