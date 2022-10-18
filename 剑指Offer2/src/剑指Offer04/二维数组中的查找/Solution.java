package 剑指Offer04.二维数组中的查找;

import java.util.Arrays;

/**
 * 由于给定的二维数组具备每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。
 *
 * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
 *
 * 可以证明这种方法不会错过目标值。如果当前元素大于目标值，说明当前元素的下边的所有元素都一定大于目标值，因此往下查找不可能找到目标值，往左查找可能找到目标值。如果当前元素小于目标值，说明当前元素的左边的所有元素都一定小于目标值，因此往左查找不可能找到目标值，往下查找可能找到目标值。
 * 时间复杂度O(n+m) 往左移最多m,往下最多n
 * 空间复杂度O(n*m)
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        return doFind(matrix,target,0,matrix[0].length-1);
    }
    boolean doFind(int[][] matrix, int target,int curX,int curY){
        if(curX<0||curX==matrix.length||curY<0||curY==matrix[0].length){
            return false;
        }
        if(target==matrix[curX][curY]) {
            return true;
        }else if(target>matrix[curX][curY]){
            return doFind(matrix,target,curX+1,curY);
        }else {
            return doFind(matrix,target,curX,curY-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] matrix = {{1, 4, 7, 11, 15},
//                {2, 5, 8, 12, 19},
//                {3, 6, 9, 16, 22},
//                {10, 13, 14, 17, 24},
//                {18, 21, 23, 26, 30}};
        int[][] matrix={{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};
        int target=5;
        System.out.println(solution.findNumberIn2DArray(matrix, target));
    }
}
