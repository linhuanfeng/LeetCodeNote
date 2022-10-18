package 剑指Offer14I.剪绳子;

/**
 * f(2)=f(1)=1
 * f(3)=max{1*f(2),1*2,2*f(1),2*1}
 * f(4)=max{1*f(3),1*3,2*f(2),2*2}
 * f(5)=max{1*f(4),1*4,2*f(3),2*3,3*f(2),3*2,4*f(1),4*1}
 * 而这些f（2）记录了计算结果，减小时间复杂度
 *
 * 时间复杂度：1+2+3+...+n=1/2(n2+n) 所以时间复杂度O(n2)
 * 空间复杂度：用到一个长度为n的dp数组，所以O(n)
 */
public class Solution {
    public int cuttingRope(int n) {
        if(n<=2){
            return 1;
        }
        int[] arr=new int[n+1];
        arr[2]=arr[1]=1;
        for (int i = 3; i <= n; i++) {
            dp(i,arr);
        }
        return arr[n];
    }
    void dp(int cur,int[] arr){
        for (int i = 1; i < cur; i++) {
            if(arr[cur-i]>cur-i){
                arr[cur]=Math.max(i*arr[cur-i],arr[cur]);
            }else {
                arr[cur]=Math.max(i*(cur-i),arr[cur]);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cuttingRope(10));
    }
}
