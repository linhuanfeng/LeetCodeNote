/**
 * 状态压缩+dp 通过
 */
public class CanIWin2 {
    public static void main(String[] args) {
        System.out.println(canIWin(10, 11));
    }

    /**
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal){
            return false;
        }
        return backtraceWitMemo(new boolean[1<<maxChoosableInteger],0, desiredTotal, maxChoosableInteger);
    }                           // 出事所有情况都是false          当前状态都是没拿

    // 只要一个稳赢就是稳赢                                        还剩多少能赢
    public static boolean backtraceWitMemo(boolean[] dp,int state,int desiredTotal,int maxChoosableInteger) {
        if(dp[state]){
            // 这个state已经被记录过了，直接返回
            return dp[state];
        }
        // 这里就是dfs
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int cur=1<<(i-1);
            if((cur&state)!=0){
                // 当前数被拿了则跳过
                continue;
            }
            // 递归出口：desiredTotal-i<=0     两种状态：（1）当前拿了就赢    （2）对面输了
            if(desiredTotal-i<=0||!backtraceWitMemo(dp,cur|state,desiredTotal-i,maxChoosableInteger)){
                return dp[state]=true;
            }
        }
        // 无论怎么选都无法让对手输，那么就是自己输了
        return dp[state]=false;
    }

}
