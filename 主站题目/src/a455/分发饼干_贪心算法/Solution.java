package a455.分发饼干_贪心算法;

import java.util.Arrays;

/**
 * 贪心算法
 * 尽力用最小的饼干满足孩子需求
 * 时间：O(nlogn) 快排的开销
 * 空间：O(1)
 */
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0, index = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (s[i] >= g[index]) {
                res++;
                index++;
            }
        }
        return res;
    }
}