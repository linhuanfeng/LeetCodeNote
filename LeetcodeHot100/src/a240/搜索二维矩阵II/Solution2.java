package a240.搜索二维矩阵II;

/**
 * Z字形搜索：
 *  从右上角（x,y）开始搜索，下面都是大于(x,y)的，左边都是小于(x,y)的
 *  因此，当m[x,y]>target时，可以安全的将y-1
 *  同理，当m[x,y]<target,x+1
 *
 *  时间：O(m+n),因为每次x++或者y--，最终越界说明未找到，所以O(m+n)
 */
class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x=0,y=matrix[0].length-1;
        while (x< matrix.length&&y>=0){
            if(matrix[x][y]==target)
                return true;
            else if (matrix[x][y]>target)
                y--;
            else
                x++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] martix={{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22},
                {10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(solution.searchMatrix(martix, 5));
    }
}