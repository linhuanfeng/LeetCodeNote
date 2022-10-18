public class Solution2 {
    public int fib(int n) {
        int a=0,b=1,sum;
        for (int i = 1; i <=n; i++) {
            sum=a%1000000007+b%1000000007;
            a=b%1000000007;
            b=sum;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().fib(1));
    }
}
