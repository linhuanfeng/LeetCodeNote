package a52.N皇后II;


/**
 * 尝试回溯法，剪枝
 * <p>
 * 状态压缩，使用三个数代替三个set,使用每一位表示每一列，行纵坐标之差，行纵坐标之和,
 * 错误，因为差值可能是负数，左移负数导致结果异常
 * <p>
 * 同列的冲突
 * 同个斜线上的也冲突，特点
 * 对于左斜线，行坐标和纵坐标之差都是相等的
 * 对于右斜线，行坐标和纵坐标之和都是相等的
 * <p>
 * <p>
 * 0 1 2 3 4
 * 0      * * *
 * 1        *
 * 2      *   *
 * 3    *
 * 4  *
 * <p>
 * 时间：O（n!）6 5 4 因为判断冲突能够O(1)
 * 空间：O(n)
 */
@Deprecated
class Solution4 {
    public int totalNQueens(int n) {
        return dfs(n, 0, 0, 0, 0); // 第一个皇后开始
    }

    /**
     * @param x 第几个皇后 0-3
     */
    int dfs(int n, int x, int a, int b, int c) {
        if (x == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if((a & 1 << i) > 0||(b & 1 << (x - i)) > 0|| (c & 1 << (x + i)) > 0){
                    continue; //
                }
//                if ((a & 1 << i) > 0) {
//                    continue;
//                }
//                if (x - i >= 0 && (b & 1 << (x - i)) > 0) {
//                    continue;
//                }
//                if ((x + i < n) && (c & 1 << (x + i)) > 0) {
//                    continue;
//                }
//                a = a | 1 << i;
//                if (x - i >= 0) {
//                    b = b | 1 << (x - i); // 与运算把位置为1
//                }
//                if(x+i<n){
//                    c = c | 1 << (x + i);
//                }
                count += dfs(n,x+1, a | 1 << i,b | 1 << (x - i),c | 1 << (x + i));
//                a = a ^ 1 << i;
//                if (x - i >= 0) {
//                    b = b ^ 1 << (x - i); // 异或把位重新置为0
//                }
//                if(x+i<n){
//                    c = c ^ 1 << (x + i);
//                }
            }
            return count;
        }
    }

    /*
    https://leetcode.cn/problems/n-queens-ii/solutions/449388/nhuang-hou-ii-by-leetcode-solution/

    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
            return count;
        }
    }
     */

    public static void main(String[] args) {
        System.out.println(new Solution4().totalNQueens(4));
    }
}