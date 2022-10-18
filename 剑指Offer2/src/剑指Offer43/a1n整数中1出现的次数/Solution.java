package 剑指Offer43.a1n整数中1出现的次数;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 时间：最多O(1)最多O(31),n的元素个数
 * 空间：O(1)常数个变量
 * 算法思想：3105
 *          3104
 *          3103
 *          每个位上1的个数加起来就是总的个数
 * 确定当前位为1，其他为取到的个数就是当前位1的个数
 */
class Solution {
    public int countDigitOne(int n) {
        int ans=0,temp=n,len=0;
        while (temp!=0){
            len++;
            temp=temp/10;
        }
        int digit=1;
        for (int i = 1; i <= len; i++) {
            int high=n/digit/10;
            int low=n%digit;
            int cur=(n/digit)%10;
            if(cur>1){
                // 此时低位随意取
                ans=ans+(high+1)*digit;
            }else if(cur==1){
                // 注意不能超过原来的数
                ans=ans+high*digit+low+1;
            }else {
                ans=ans+high*digit;
            }
            digit*=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(2));
    }
}