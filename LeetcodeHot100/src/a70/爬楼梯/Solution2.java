package a70.爬楼梯;

/**
 * f(4)=f(3)+f(2)
 * f(3)=f(2)+f(1)
 * 所以很多地方其实重复调用了
 * 采用动态规划进行优化
 * 时间：O(n)
 * 空间：O(1)常数级别
 */
class Solution2 {
    public int climbStairs(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int a=1,b=2,ans=0;
        for (int i = 3; i <=n ; i++) {
            ans=a+b;
            a=b;
            b=ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }
}