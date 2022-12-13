package a52.N皇后II;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 尝试回溯法，剪枝
 *
 * 不用状态压缩竟然更快
 *
 * 如何快速判断是否冲突，使用set存储快速判断冲突
 * 同列的冲突
 * 同个斜线上的也冲突，特点
 *  对于左斜线，行坐标和纵坐标之差都是相等的
 *  对于右斜线，行坐标和纵坐标之和都是相等的
 *
 * 因此使用set快速判断是否冲突
 *
 *    0 1 2 3 4
 * 0      * * *
 * 1        *
 * 2      *   *
 * 3    *
 * 4  *
 *
 * 时间：O（n!）6 5 4 因为判断冲突能够O(1)
 * 空间：O(n)
 *
 */
class Solution2 {
    public int totalNQueens(int n) {
        dfs(n,0,new HashSet<Integer>(),new HashSet<Integer>(),new HashSet<Integer>()); // 第一个皇后开始
        return res;
    }
    int res=0;

    /**
     *
     * @param x 第几个皇后 0-3
     */
    void dfs(int n,int x, Set<Integer> a,Set<Integer> b,Set<Integer> c){
        if(x==n){
            res++;
            return;
        }
        for (int i = 0; i <n; i++) {
            if(a.contains(i)||b.contains(x-i)||c.contains(x+i)){
                continue;
            }
            a.add(i);
            b.add(x-i);
            c.add(x+i);
            dfs(n, x+1, a, b, c);
            a.remove(i);
            b.remove(x-i);
            c.remove(x+i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().totalNQueens(4));
    }
}