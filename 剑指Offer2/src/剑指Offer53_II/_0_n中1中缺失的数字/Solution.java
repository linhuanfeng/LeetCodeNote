package 剑指Offer53_II._0_n中1中缺失的数字;
/**
 *
 * 二分
 * [0]
 *  1
 *
 *  时间：O(logn)
 *  空间：O（1）
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int i=0,j=nums.length-1;
        while (i<=j){ // 要等于，排除【0】的情况
            int mid=i+(j-i)/2; // 防止爆int
            if(mid==nums[mid]){
                // 在右边
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution3 = new Solution();
        System.out.println(solution3.missingNumber(new int[]{0}));
    }
}
