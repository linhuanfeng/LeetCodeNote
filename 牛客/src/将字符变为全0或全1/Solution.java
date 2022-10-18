package 将字符变为全0或全1;
// https://www.nowcoder.com/discuss/1065321
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return int整型
     */
    public int minOperations(String str) {
        if (str.length() == 1) {
            return 0;
        }
        // write code here
        // 假设抹除0
        char[] chars = str.toCharArray();
        int ans = 0, last = -1;
        int ans2 = 0, last2 = -1;
        if (chars[0] == '0') {
            last = 0;
            ans++;
        }
        if (chars[0] == '1') {
            last2 = 0;
            ans2++;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (last == i - 1) {
                    last = -1; // 已出现
                }else {
                    ans++; // 第一次出现
                    last=i;
                }
            }else {
                if (last2 == i - 1) {
                    last2 = -1; // 已出现
                }else {
                    ans2++; // 第一次出现
                    last2=i;
                }
            }
        }
        return Math.min(ans,ans2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations("1001101"));
    }
}