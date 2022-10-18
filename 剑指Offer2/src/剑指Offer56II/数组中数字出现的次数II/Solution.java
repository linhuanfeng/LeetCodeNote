package 剑指Offer56II.数组中数字出现的次数II;


/**
 * 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
 * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int[] count=new int[32];
        int ans;
        for (int num:nums) {
            for (int i = 0; i < 31; i++) {
                count[i]=(count[i]+((num>>i)&1))%3;
            }
        }
        ans=count[0];
        for (int i = 1; i < count.length; i++) {
            ans+=count[i]*Math.pow(2,i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={3,4,3,3};
        System.out.println(solution.singleNumber(nums));
    }
}
