public class EggDropWith2EggsAndNFloors {
    public static void main(String[] args) {
        System.out.println(twoEggDrop(10));
    }
    public static int twoEggDrop(int n) {
        int INF=Integer.MAX_VALUE/2;
        int[][] dp=new int[3][n+1];
        for (int i = 2; i <3; i++) {// 鸡蛋数
            for (int j = 1; j <=n; j++) {// 楼层数
                dp[i][j]=INF;
            }
        }
        for (int i = 1; i <= n; i++) {// 一个鸡蛋的时候进行初始化
            dp[1][i]=i;
        }
        for (int i = 2; i <= 2; i++) {// 鸡蛋数
            for (int j = 1; j <= n; j++) {// 楼层数
                for (int k = 1; k <=j; k++) {// 从哪一层开始试
                    dp[i][j]=Math.min(Math.max(dp[i-1][k-1],dp[i][j-k])+1,dp[i][j]);//每层开始扔的的最坏情况，找出哪一层扔次数最少
                }
            }
        }
        return dp[2][n];
    }
}
