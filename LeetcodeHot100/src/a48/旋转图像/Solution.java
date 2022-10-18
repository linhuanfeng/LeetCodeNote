package a48.旋转图像;

/**
 * 矩阵顺时针旋转90度，第一行会变到倒数第一列，第二行变到倒数第二列
 * 即 m[i,j]要存到 m[j][n-i-1](new)中，设
 * ①raw=j
 * ②col=n-i-1

 * 反推,当前m[raw][col]对应存放m[i][j]
 * ①i=n-col-1
 * ②j=raw
 *  即m[i][j](new)应存放原来 m[n-col-1][raw]的数
 *
 *
 *  比如 使用temp=m[i][j]
 *         m[i][j]=m[n-j-1][i]
 *         m[n-j-1][i]=m[n-i-1][n-j-1]
 *         ...
 * 时间：O(n^2)
 * 空间：O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for (int i = 0; i < n/2; i++) { // 行奇数和偶数都死一样的位置
            for (int j = 0; j < (n+1)/2; j++) { // m[n-col-1][raw] 列偶数一样，奇数的时候要多加一位
                int temp=matrix[i][j];
                matrix[i][j]= matrix[n-j-1][i]; // 注意这里总共四次就够了
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        solution.rotate(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}