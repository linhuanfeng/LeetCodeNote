package 比较版本号;

/**
 * (优化空间复杂度)双指针，分割的时候直接判断
 * <p>
 * 时间：O(max(n,m)) 版本号的长度
 * 空间：O(1)
 */
class Solution2 {
    public int compareVersion(String version1, String version2) {
        int n = version1.length(),
                m = version2.length();

        for (int i = 0, j = 0; i < n || j < m; ) {
            int x = 0, y = 0;
            for (; i < n && version1.charAt(i) != '.'; i++) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            for (; j < m && version2.charAt(j) != '.'; j++) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            i++; // 跳过‘.’
            j++;

            if (x > y) {
                return 1;
            } else if (x < y) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().compareVersion("1.0.1", "1"));
    }
}
