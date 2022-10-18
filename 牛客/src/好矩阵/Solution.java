package 好矩阵;


/*
作者：神崎兰子
链接：https://www.nowcoder.com/discuss/1065321
来源：牛客网

题意：求n*mn∗m的矩阵，每个元素都在[1,x][1,x]区间，满足任意2*2子矩阵之和为偶数的矩阵数量。

知识点：组合数学

我们可以先确定第一行和第一列，每个格子上有xx种不同的取法，共有n+m-1n+m−1个格子。因此这些格子的取法总数为x^{n+m-1}x
n+m−1
 。

当第一行和第一***定了以后，其余的格子的奇偶性也就确定下来了。无论是奇数还是偶数，每个格子的取法都是\frac{x}{2}
2
x
​
 种，因此取法为({\frac{x}{2}})^{(n-1)*(m-1)}(
2
x
​
 )
(n−1)∗(m−1)


把这两个答案乘起来就是最终的答案。

由于指数很大，所以要用快速幂：即利用a^{x}=(a^{\frac{x}{2}})^2a
x
 =(a
2
x
​

 )
2
 快速计算乘方。


class Solution {
public:
    int mod=1e9+7;
    int power(int a,long long b){
        int res=1;
        while(b){
            if(b&1)res=1LL*res*a%mod;    //注意这里会爆int，所以要先转long long。
            b>>=1;
            a=1LL*a*a%mod;
        }
        return res;
    }
    int numsOfGoodMatrix(int n, int m, int x) {
        return 1LL*power(x,n+m-1)*power(x/2,1LL*(n-1)*(m-1))%mod;
    }
};
当然python已经将快速幂封装好了，所以如果用python的话本题只有一行代码（滑稽）：

复制代码
1
2
3
class Solution:
    def numsOfGoodMatrix(self , n: int, m: int, x: int) -> int:
        return pow(x,n+m-1,10**9+7)*pow(x//2,(n-1)*(m-1),10**9+7)%(10**9+7)
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @param m int整型
     * @param x int整型
     * @return int整型
     */
    public int numsOfGoodMatrix(int n, int m, int x) {
        // write code here
        int[][] arr = new int[n][m];
        int count=n*m-1;
        for (int i = 1; i <= x; i++) {
            arr[0][0]=i;
            dfs(arr,0,0,x,count);
            arr[0][0]=0;
        }
        return (int) (ans%1000000009);
    }

    long ans = 0;
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};

    void dfs(int[][] arr, int x, int y, int k, int count) {
        if (count == 0) {
            if (check(arr)) {
                ans++;
            }
        }
        for (int i = 0; i < 4; i++) {
            int tx=x+dx[i],ty=y+dy[i];
            if(tx>=0&&tx<arr.length&&ty>=0&&ty<arr[0].length&&arr[tx][ty]==0){
                for (int j = 1; j <= k; j++) {
                    arr[tx][ty]=j;
                    dfs(arr, tx, ty, k, count-1);
                    arr[tx][ty]=0;
                }
            }
        }
    }


    private boolean check(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[0].length - 1; j++) {
                int ans = 0;
                ans += arr[i][j] % 2 + arr[i][j + 1] % 2 + arr[i + 1][j] % 2 + arr[i + 1][j + 1] % 2;
                if (ans % 2 != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numsOfGoodMatrix(2, 2, 2));
        int[][] ints = {{1, 2}, {2, 1}};
//        System.out.println(new Solution().check(ints));
    }
}