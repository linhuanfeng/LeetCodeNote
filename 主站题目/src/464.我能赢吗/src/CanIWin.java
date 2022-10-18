/**
 * 超时
 */
public class CanIWin {
    public static void main(String[] args) {
        System.out.println(canIWin(10, 11));
    }

    /**
     * 记忆化回溯（也称为递归+备忘录），自顶向下
     * 采用记忆化后的时间复杂度为O(2^n)(如果不进行记忆的话，时间复杂度将是O(n!))，可以理解为已经缩成了只有一个分支了
     * 然后为什么要进行记忆化：
     * 因为我们发现，例如[2,3]和[3,2]之后的玩家选择状态都是一样的，都是可以从除了2,3之外的
     * 数字进行选择，那么就可以对选择2和3后第一个玩家能不能赢进行记忆存储
     * 这里采用state[]数组存储每个数字是否都被选过，选过则记录为1，然后我们将state.toString()
     * 使得[2,3]和[3,2]它们的结果都是一样的"0011"，作为key，存储在HashMap中，value是选了2和3
     * 之后第一个玩家是否稳赢
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        return backtraceWitMemo(new int[maxChoosableInteger + 1], desiredTotal, maxChoosableInteger);
    }

    // 这个不就是dfs吗
    public static boolean backtraceWitMemo(int[] state,int desiredTotal,int maxChoosableInteger) {
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if(state[i]==1){
                continue;
            }
            state[i]=1;
            if(desiredTotal-i<=0||!backtraceWitMemo(state,desiredTotal-i,maxChoosableInteger)){// 两个状态：当前数拿了就赢；对面输了
                state[i]=0;
                return true;
            }
            state[i]=0;
        }
        return false;
    }

}
