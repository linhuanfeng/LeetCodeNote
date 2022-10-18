package a62.不同路径;

import java.util.Arrays;

/**
 * 普通dfs肯定是超时的，
 * dp,从右下角开始，用一个m的数组后一列的数,右下角不需要用到，可用来存储下边的步数
 * 时间：O(m*n) 遍历一遍
 * 空间：O(m):col数组存储一列
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] col=new int[m];
        Arrays.fill(col,1);
        for (int j = n-2; j >=0 ; j--) {
            for (int i = m-2; i >=0 ; i--) {
                col[i]=col[i]+col[i+1]; // 当前的步数等于右边和下边的步数之和
            }
        }
        return col[0];
    }
//    void dfs(int m,int n,int i,int j){
//        if(i==m-1&&j==n-1){
//            ans++;
//            return;
//        }
//        if(i+1<m){
//            dfs(m,n,i+1,j);
//        }
//        if(j+1<n){
//            dfs(m, n, i, j+1);
//        }
//    }
}