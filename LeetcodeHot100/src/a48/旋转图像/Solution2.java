package a48.旋转图像;

/**
 * 对角线翻转（顺时针就主对角线，逆时针就副对角线），再左右翻转。效果等于旋转
 * 时间：O(n^2)
 * 空间：O(1)
 */
class Solution2 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // 左右翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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