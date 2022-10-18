package 阶乘问题;

/**
 * 整形溢出问题：在整除的情况下求余
 *
 * 对组合数进行化简：c(r,n)=c(3,9)=9*8*7/3*2*1
 * 当r>n/2时，r=n-r;
 *
 *
 * 时间复杂度：O(n) r>(n/2)?n-r:r
 */
public class Solution {
    public int combination (int r, int n) {
        int ans=1,m=1;
        if(r>n/2){ // 根据以上的化简公式，得出r取较小值 且除数和被除数求阶乘的次数是相同的
            r=n-r;
        }
        while (r>=1){ // 等于1也包括在内
            ans*=n; // 被除数
            m*=r; // 除数
            if(ans%m==0){ // 结果肯定是整除的，同时也防止溢出
                ans/=m;
                m=1;
            }
            n--;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combination(1,2147483647));
    }
}
