package a461.汉明距离;

/**
 * 时间复杂度：log(C),C是数据的范围，log2^31=31
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        x = x ^ y;
        while (x > 0) {
            if((x&1)>0){
                ans++;
            }
            x=x>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
    }
}