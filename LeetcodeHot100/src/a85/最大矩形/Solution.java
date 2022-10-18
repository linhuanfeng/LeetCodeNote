package a85.最大矩形;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 使用left[i][j]表示i,j右边的1的个数，
 * 那么对于每一列来说，就转换成为一个84.柱状图中最大的矩形
 * 时间：O(mn)求最大柱状图为O(m),外面再套一层n循环
 * 空间：O(mn)
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        // 填充left数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (j > 0) {
                        left[i][j] = left[i][j - 1] + 1;
                    } else {
                        left[i][j] = 1;
                    }
                }
            }
        }
        int max=0;
        for (int j = 0; j < n; j++) {
            // 每一列当作柱状图来计算,注意stack和up,down提到里面来，避免重新初始化
            Deque<Integer> stack = new LinkedList<>();
            int[] up = new int[m], down = new int[m]; // 分别表示上和下小于当前高度的最小柱子
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            stack.clear();
            for (int i = m-1; i >=0 ; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }
            for (int i = 0; i < m; i++) {
                max=Math.max(max,left[i][j]*(down[i]-up[i]-1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars=new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(solution.maximalRectangle(chars));
    }
}