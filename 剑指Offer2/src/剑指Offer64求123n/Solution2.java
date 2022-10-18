package 剑指Offer64求123n;

/**
 * 时间复杂度：O(n) 因为n n-1 n-2 ... 1递归深度为n
 * 空间复杂度：O(n)递归深度达到n,系统使用O(n)的额外空间
 */
public class Solution2 {
    public int sumNums(int n) {
        // n=1 递归出口 利用&&或||的短路运算
        boolean temp=n>1&&(n+=sumNums(n-1))>0;
        return n;
    }
}