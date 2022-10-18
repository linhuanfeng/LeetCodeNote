package 剑指Offer56I.数组中数字出现的次数;

/**
 * 记两个只出现一次的数字为a,b
 * 0^x=x
 * x^x=0
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0;
        // 得到a^b的值为x 因为：a^b^c^c^d^d=a^b
        for (int num : nums) {
            x^=num;
        }
        /*
         1.一个数组中只有一个数a只出现一次，那么把所有数进行异或得到的值为a
         2.因此我们把只出现一次的两个数分到两个的数组中，并且两个数组中除了这两个数之外其他都是成对存在，满足1
         3.怎么分为两个数组：
            任取x中一个不为0的二进制位，和每个数进行异或，为0分为一组，不为0的分到另一组
            因此：a,b在该二进制位一定是不同，那么一定会被分到两个不同的组
                 如果相同的数，那么该二进制位一定是一样的，那么也会被分到不同的组
         */
        int flag=0;
        while((x>>flag&1)!=1){
            // 找出第一个不为1的二进制位（最低为记为0）
            flag++;
        }
        int[] res={0,0};
        for (int num : nums) {
            if((num>>flag&1)==1){
                res[0]^=num;
            }else {
                res[1]^=num;
            }
        }
        return res;
    }
}
