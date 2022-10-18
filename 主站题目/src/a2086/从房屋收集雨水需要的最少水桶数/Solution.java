package a2086.从房屋收集雨水需要的最少水桶数;

/**
 * 贪心
 * <p>
 * 每次能往右边放东西就往后面放，右边不能放（右边是桶或者边界）才往左边放
 * 因为如果先往左边放的话，左边的左边的房屋已经被桶接了，没有意义
 * 左边不能放（房屋或者边界，那么无解返回-1）
 * <p>
 * 时间：O(n)
 * 空间：O(1)
 */
class Solution {
    public int minimumBuckets(String street) {
        char[] charArray = street.toCharArray();
        int n = charArray.length, ans = 0;

        for (int i = 0; i < n; i++) {
            if (charArray[i] == 'H') {
                if (i + 1 < n && charArray[i + 1] == '.') { // 优先放右边
                    charArray[i + 1] = 'B';
                    ans++;
                    i += 2; // 后两位都能被桶盛
                } else if (i > 0 && charArray[i - 1] == '.') { // 不满足再放左边
                    ans++;
                } else {
                    return -1; // 无解
                }
            }
        }
        return ans;
    }
}