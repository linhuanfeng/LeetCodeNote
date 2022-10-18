/**
 * k可采用二分
 * 还没写好
 */
public class EggDropWith2EggsAndNFloors2 {
    public static void main(String[] args) {
        twoEggDrop(100);
    }
    public static int twoEggDrop(int n) {
        int INF=Integer.MAX_VALUE/2;
        int[][] dp=new int[3][n+1];
        for (int i = 2; i <3; i++) {
            for (int j = 1; j <=n; j++) {
                dp[i][j]=INF;
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[1][i]=i;
        }
        for (int i = 2; i <= 2; i++) {// 鸡蛋数
            for (int j = 1; j <= n; j++) {// 楼层数
                // 从哪一层开始试
                int l=1,r=j;
                while(l<r){
                    int m=(l+r)/2;
                    int t1=dp[i-1][m-1];
                    int t2=dp[i][j-m];
                    if(t1>t2){
                        r=m-1;
                    }else{
                        l=m+1;
                    }
                }
                dp[i][j]=Math.min(Math.max(dp[i-1][l-1],dp[i][j-l])+1,dp[i][j]);
            }
        }
        for (int i = 0; i <=2; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[0][0]);
        return 0;
    }
}
