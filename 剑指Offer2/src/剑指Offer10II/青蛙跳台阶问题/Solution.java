package 剑指Offer10II.青蛙跳台阶问题;

/**
 * 超时
 */
public class Solution {
    public int numWays(int n) {
        final int mod=1000000007;
        if(n==0){
            return 1;
        }
        if(n<=2){
            return n;
        }
        return (numWays(n-1)%mod+numWays(n-2)%mod)%mod;
    }
}
