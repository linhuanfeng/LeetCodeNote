package 剑指Offer12.矩阵中的路径;

/**
 * ac但用时比较多
 * 时间复杂度 O(3^KMN)O(3^K MN) ： 最差情况下，需要遍历矩阵中长度为 K 字符串的所有方案，时间复杂度为 O(3^k)
 *      矩阵中共有 MN 个起点，时间复杂度为 O(MN)。
 *      搜索中每个字符有上、下、左、右四个方向可以选择，舍弃回头（上个字符）的方向，剩下 33 种选择，因此方案数的复杂度为 O(3^K)
 * 空间复杂度：visit数组的开销O(nm) 理解错误
 *      空间复杂度 O(K)： 搜索过程中的递归深度不超过 K，因此系统因函数调用累计使用的栈空间占用 O(K)
 *      （因为函数返回后，系统调用的栈空间会释放）。最坏情况下 K = MN ，递归深度为 MN ，此时系统栈使用 O(MN)O 的额外空间。
 */
public class Solution {
    int[] dx={0,1,0,-1};
    int[] dy={1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = dfs(board, new boolean[board.length][board[0].length], i, j, word, 0);
                if(res){
                    return res;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board,boolean[][] visit,int curX,int curY,String word,int index){
        if(word.charAt(index)!=board[curX][curY]){
            // 所有元素匹配完
            return false;
        }
        if(index==word.length()-1){
            // 遍历到最后一个了
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int tx=curX+dx[i];
            int ty=curY+dy[i];
            if(tx>=0&&tx<board.length&&ty>=0&&ty<board[0].length&&!visit[tx][ty]){
                visit[curX][curY]=true;
                boolean res = dfs(board, visit, tx, ty, word, index + 1);
                if(res){
                    return true;
                }
                visit[curX][curY]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board={{'A','B','C','E'},
//                {'S','F','C','S'},
//                {'A','D','E','E'}};
//        String word="ABCCED";
        char[][] board={{'a','b'},{'d','c'}};
        String word="abcd";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
