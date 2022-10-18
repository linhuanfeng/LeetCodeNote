package 剑指Offer40.最小的k个数;

import java.util.Arrays;

/**
 * 基于快排:基准数左边的比他大，右边的比他小，那么基准数的索引如果在第k位，那么前面的就是结果了
 *      时间复杂度：O(N)
 *      空间复杂度：平均递归深度为O(logN)
 */
public class Solution3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k>=arr.length){
            return arr;
        }
        if(k==0){
            return new int[0];
        }
        return quickSort(arr,0,arr.length-1,k);
    }

    public int[] quickSort(int[] arr,int left,int right,int k){
        int i=left,j=right,temp=arr[left];
        while (i<j){
            while (arr[j]>=temp&&i<j){
                j--;
            }
            arr[i]=arr[j];
            while (arr[i]<=temp&&i<j){
                i++;
            }
            arr[j]=arr[i];
        }
        arr[i]=temp;
        if(i>k-1){
            return quickSort(arr, left, i-1, k);
        }else if (i<k-1){
            return quickSort(arr, i+1, right, k);
        }
        return Arrays.copyOf(arr,k);
    }

    public static void main(String[] args) {
        int[] arr={0,0,0,2,0,5};
        Solution3 solution = new Solution3();
        for (int item : solution.getLeastNumbers(arr, 0)) {
            System.out.print(item+" ");
        }
    }
}
