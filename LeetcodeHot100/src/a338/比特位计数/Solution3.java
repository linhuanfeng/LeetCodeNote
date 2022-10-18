package a338.比特位计数;

/**
 * 动态规划：最高比特位
 * x=10110
 * y=10000
 *  y小于等于x且是2的整数次幂，可通过y&(y-1)==0判断,称y为x的最高有效位
 *  如果获取最高比特位：从1开始，如果i&(i-1)==0,说明当前是2的整数次幂且一定小于等于当前i
 * z=00110
 * 那么易得转移方程：bits[x]=bits[z]+1
 * 时间：O(n)
 */
class Solution3 {
    public int[] countBits(int n) {
//        Integer.bitCount()
        int[] ans=new int[n+1];
        int highBit=1;
        for (int i = 1; i <=n ; i++) {
            if((i&(i-1))==0)
                highBit=i;
            ans[i]=ans[i-highBit]+1;
        }
        return ans;
    }
}