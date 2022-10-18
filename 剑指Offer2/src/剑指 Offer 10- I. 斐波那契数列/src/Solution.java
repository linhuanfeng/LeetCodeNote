public class Solution {
    public int fib(int n) {
        return fibTail(n,0,1);
    }
    public int fibTail(int n,int p1,int p2){
        if(n==0){
            return p1%1000000007;
        }
        // 使用尾递归，避免中间结果的栈开销
        return fibTail(n-1,p2%1000000007,(p1+p2)%1000000007);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fib(45));
    }
}
