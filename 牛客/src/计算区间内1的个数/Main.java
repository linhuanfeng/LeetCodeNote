package 计算区间内1的个数;

import java.util.Scanner;
/*
作者：Comrades
链接：https://www.nowcoder.com/discuss/1078543
来源：牛客网

由于我们要求区间 [L, R][L,R] 内的 11 的个数，转化为求 [1, R] - [1, L-1][1,R]−[1,L−1] 的 11 的个数比较好。下面介绍如何求解 [1, R][1,R] 的 11 的个数。

当 R = 2^nR=2
n
 ，显然可以知道其中一半的位置都是 11.

我们找到小于等于 RR 最大的 nn，有 2^n \le R2
n
 ≤R，对答案的贡献为：2^{n-1}2
n−1
 , 还剩下：R - 2^nR−2
n
 。

剩下的部分无非是前部分的反转，因此我们可以递归的求解 (R - 2^nR−2
n
 )，但是由于首位中 11 变为了 00，我们需要知道这一点。

当最后 R = 1R=1 时，如果我们记录的首位为 11，那么答案是 11，如果首位是 00，那么答案是 00。
#include <bits/stdc++.h>

using namespace std;

using ll = long long;

ll cal(ll num, int bit) {
    if (num == 0) return 0;
    else if (num == 1) return bit;
    else if (num == 2) return 1;
    ll x = 0;
    while ((1ll << x) <= num) ++x;
    --x;
    num -= (1ll<<x);
    ll ans = 0;
    if (x > 0) {
        ans += (1ll<< (x-1));
    }
    return ans + cal(num, 1-bit);
}

int main() {
    ll L, R; cin >> L >> R;
    cout << cal(R, 1) - cal(L-1, 1) << endl;
    return 0;
}
 */

/*
作者：机器也学不会
链接：https://www.nowcoder.com/discuss/1078565
来源：牛客网

第四题首先要想明白这个公式，count(2i) = count(2i-1) + 2i-1 - count(2i-1) = 2i-1 。也就是说对于前2i个位置中1的个数是2i-1。所以对于任意位置n，把n拆成2i + d 递归处理就好了，递推公式：dp[n] = 2i-1+ d - dp[d] (i = log2n 向下取整)。代码加了记忆化，其实加不加时间差不多
复制代码
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
unordered_map<long long, long long> dp;
long long DFS(long long n)
{
    if (n == 0)
        return 0;
    else if (n <= 2)
        return 1;
    if(!dp.count(n))
    {
        long long i = log2l(n);
        long long d = n - pow(2, i);
        dp[n] = pow(2, i - 1) + d - DFS(d);
    }
    return dp[n];
}

int main()
{
    long long L, R;
    cin >> L >> R;
    cout << DFS(R) - DFS(L - 1);
    return 0;
}
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left=sc.nextInt(),right=sc.nextInt();

        boolean[] arr=new boolean[right];

        arr[0]=true;
        arr[1]=false;
        int cnt=2;
        /*
         2 2 3
         4
         */
        int x=cnt,y=cnt*2-1;
        while (true){
            int i=x;
            for (; i <=y&&i<=right-1 ; i++) {
                arr[i]=!arr[i-cnt];
            }
            if(i>right-1){
                break;
            }
            cnt*=2;
            x=cnt;
            y=cnt*2-1;
        }
        long res=0;
        for (int i = left-1; i <right ; i++) {
            if(arr[i]){
                res++;
            }
        }
        System.out.println(res);
    }
}
