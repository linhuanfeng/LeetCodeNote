package 剑指Offer29.顺时针打印矩阵;

/**
 * 按层模拟
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        // 特殊值判断
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        int[] res=new int[matrix.length*matrix[0].length];
        int index=0;
        while (left<=right&&top<=bottom){
            // 上一层
            for (int i = left; i <=right ; i++) {
                res[index++]=matrix[top][i];
            }
            for (int i = top+1; i <=bottom ; i++) {
                res[index++]=matrix[i][right];
            }
            if(index==res.length){
                break;
            }
            for (int i = right-1; i>=left ; i--) {
                res[index++]=matrix[bottom][i];
            }
            for (int i = bottom-1; i>top ; i--) {
                res[index++]=matrix[i][left];
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }
}
