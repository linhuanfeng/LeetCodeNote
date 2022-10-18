package 连续子数组数量;

import java.util.*;
/*
给一个数组，找一段区间，其区间内的积的后缀有不少于x个0；给定x之后求有多少种这样的区间。
思路：
统计每个数内2和5的个数，然后前缀和。
 */
/*
作者：神崎兰子
链接：https://www.nowcoder.com/discuss/1065321
来源：牛客网

题意：求乘积尾零数量大于xx的连续子数组数量。

知识点：双指针/二分

本题本质是维护min(cnt_2,cnt_5)\geq xmin(cnt
2
​
 ,cnt
5
​
 )≥x的区间数量。由于满足单调性，所以可以双指针/二分解决。

双指针；遍历右指针，当不合法时左指针右移，复杂度O(n)O(n)。（也可以遍历左指针，不过更推荐遍历右指针的写法，代码更好写）

双指针做法参考代码：
class Solution {
public:
    int f(int x,int p){    //计算x中有多少个因子p。
        int cnt=0;
        while(x%p==0)x/=p,cnt++;
        return cnt;
    }
    int getSubarrayNum(vector<int>& a, int x) {
        int i,n=a.size(),j,cnt2=0,cnt5=0,res=0,mod=1e9+7;
        for(i=0,j=0;i<n;i++){
            cnt2+=f(a[i],2);
            cnt5+=f(a[i],5);
            while(min(cnt2,cnt5)>=x){    //找到第一个不合法的区间左端点，该左端点的左边全部合法。
                cnt2-=f(a[j],2);
                cnt5-=f(a[j],5);
                j++;
            }
            res=(res+j)%mod;
        }
        return res;
    }
};
二分：首先用前缀和可以求出前ii项的2因子和5因子数量，这样就可以O(1)O(1)查询区间的因子数量了。

二分的时候，枚举左端点，在前缀和数组上找到第一处合法的右端点即可。复杂度 O(nlogn)O(nlogn)。

本题在笔试中不建议用二分写法，复杂度比双指针大，并且写起来也比双指针麻烦。不过二分算法还是建议大家掌握的，用处非常多。

二分参考代码：

class Solution {
public:
    int f(int x,int p){    //计算x种有多少个因子p。
        int cnt=0;
        while(x%p==0)x/=p,cnt++;
        return cnt;
    }
    int sum2[101010]={},sum5[101010]={};
    int check(int idx,int mid,int x){    //判断[idx,mid]区间的乘积尾零是否大于x
        int cnt2=sum2[mid],cnt5=sum5[mid];
        if(idx)cnt2-=sum2[idx-1],cnt5-=sum5[idx-1];    //这里前缀和需要判0。可以前缀和数组下标从1开始来规避这个问题。
        return min(cnt2,cnt5)>=x;
    }
    int bs(int idx,int l,int r,int x){    //在a数组中，固定左端点为idx，二分找最小合法右端点的位置。
        if(!check(idx,r,x))return r+1;    //右端点不合法需要特判。
        if(l==r)return l;
        int mid=l+r>>1;//等价于(l+r)/2。
        if(check(idx,mid,x))return bs(idx,l,mid,x);    //合法二分递归向左找。
        return bs(idx,mid+1,r,x);    //不合法则向右找。
    }
    int getSubarrayNum(vector<int>& a, int x) {
        int i,n=a.size(),j,cnt2=0,cnt5=0,res=0,mod=1e9+7;
        for(i=0;i<n;i++){
            sum2[i]=cnt2+=f(a[i],2);    //习惯了可以这样写前缀和，也可以把sum2[i]=cnt2放到下面。
            sum5[i]=cnt5+=f(a[i],5);
        }
        for(i=0;i<n;i++){
            res+=n-bs(i,i,n-1,x);    //找到第一个合法的右端点，其右边均为合法区间。
            res%=mod;
        }
        return res;
    }
};
 */
// 20 被0除
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型ArrayList 
     * @param x int整型 
     * @return int整型
     */
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        int weight=1;
        long ans=0;
        for (int i = 0; i < x; i++) {
            weight*=10;
        }
        // write code here
        for (int i = 0; i < a.size(); i++) {
            long t=1;
            int count0=0;
            for (int j = i; j < a.size(); j++) {
                t=t%weight;
                // 和当前数相乘
                t=t*a.get(j);
                long[] longs = delete0(t); // 削去t的0
                count0+=longs[0];
                t=longs[1];
                if(count0>=x){
                    ans++;
                }
            }
        }
        return (int) (ans%1000000009);
    }
    int count0(long i){
        int ans=0;
        while (i>1){
            if(i%10==0){
                i/=10;
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
    long[] delete0(long i){
        int ans=0;
        while (i>1){
            if(i%10==0){
                i/=10;
                ans++;
            }else {
                break;
            }
        }
        return new long[]{ans,i};
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(50);
        list.add(4);
        System.out.println(new Solution().getSubarrayNum(list, 2));
    }
}