package a136.只出现一次的数字;

class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        // 1^1^0=0  0^0^0=0 所以两两抵消，只剩下只有一个的数
        for (int num : nums) {
            ans=ans^num;
        }
        return ans;
    }
}