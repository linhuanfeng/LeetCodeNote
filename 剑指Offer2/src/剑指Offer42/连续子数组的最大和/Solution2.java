package 剑指Offer42.连续子数组的最大和;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        // 用变量替换dp数组，节省内存 因为只需要知道当前值和
        /**
         * pre 以pre结尾的最大子串和
         * cur 以cur结尾的最大子串和
         * 用变量替换dp数组，节省内存 因为只需要知道当前值和前一个
         */
        int pre,cur,res;
        res=pre=nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur=Math.max(nums[i],nums[i]+pre);
            res=Math.max(res,cur);
            pre=cur;
        }
        return res;
    }
}
