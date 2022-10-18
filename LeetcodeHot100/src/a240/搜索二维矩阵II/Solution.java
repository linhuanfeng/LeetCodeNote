package a240.搜索二维矩阵II;

/**
 * 对每一行进行二分
 * 时间：O(mlogn)
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if(midSortRow(ints,target))
                return true;
        }
        return false;
    }
    public boolean midSortRow(int[] arr,int target){
        int left=0,right=arr.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] martix={{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22},
                {10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(solution.searchMatrix(martix, 5));
    }
}