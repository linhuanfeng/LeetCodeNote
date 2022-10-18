package 剑指Offer10II.青蛙跳台阶问题;

/**
 * 时间复杂度：为n的个数 O(n)
 * 空间复杂度：
 */
public class Solution2 {
    public int numWays(int n) {
        // 特殊情况，楼梯为0，情况1种
        if(n==0){
            return 1;
        }
        return doNum(n,1,1);
    }
    int doNum(int n,int fir,int sec){
        final int mod=1000000007;
        if(n==0){
            return fir;
        }
        // 尾递归第二个存储结果
        return doNum(n-1,sec%mod,(fir+sec)%mod)%mod;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.numWays(7));
    }
}
