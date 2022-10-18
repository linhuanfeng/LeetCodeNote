package 软通杯.第三题;

import java.util.Scanner;

/**
 * windy 定义了一种 windy 数。
 *
 * 题目描述
 * 不含前导零且相邻两个数字之差至少为 22 的正整数被称为 windy 数。windy 想知道，
 * 在 aa 和 bb 之间，包括 aa 和 bb ，总共有多少个 windy 数？
 * 输入
 * 1 10
 * 输出
 * 9
 * 输入
 * 25 50
 * 输出
 * 20
 */
public class Main {
    int[][] dp=null;
    int[] a=null; // 记录每一位上面的数字
    void init(){
        a=new int[11];
        dp=new int[11][11];
        for (int i = 0; i <=9 ; i++) {
            dp[1][i]=1; // 0,1,2..9都属于windy数
        }
        for (int i = 2; i <11 ; i++) {
            for (int j = 0; j <=9 ; j++) {
                for (int k = 0; k <=9 ; k++) {
                    if(Math.abs(j-k)>=2){
                        dp[i][j]+=dp[i-1][k];
                    }
                }
            }
        }// 从最高位i=2开始，每次枚举最高位值j并找到k,使得j-k>=2
    }
    int work(int x){ //计算<=x的数
        int len=0,ans=0;
        while (x!=0){
            // 将x每一位数字放到a[i]中
            a[++len]=x%10;
            x=x/10;
        }
        // 分为几个模块，先求len-1位的windy数，必定包含在区间里的
        for (int i=1;i<=len-1;i++){
            for (int j = 1; j <=9 ; j++) {
                ans+=dp[i][j];
            }
        }
        // 求len位的windy数，且小于a[len]的值
        for (int i =1 ; i <a[len] ; i++) {
            ans+=dp[len][i];
        }
        // 求len的windy数，且等于a[len]的值
        for (int i = len-1; i >=1 ; i--) {
            // i从最高位后开始枚举
            for (int j = 0; j <=a[i]-1 ; j++) {
                // J是i位上的数
                if(Math.abs(j-a[i+1])>=2){ // 判断和上一位相差2以上
                    ans+=dp[i][j];
                }
            }
            if(Math.abs(a[i+1]-a[i])<2){
                break; //当高位不满足wendy数的时候，低位满足也没用
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        // dp[i][j] 表示第i位的数为j
        // 那么 dp[i][j]=dp[i-1][k]  abs(j-k)>=2
        // 初始值 dp[1][k] =1  1<=k<=9  // 1-9都是windy数
        Main main = new Main();
        main.init();
        System.out.println(main.work(b+1)-main.work(a));
        scan.close();
    }
}
