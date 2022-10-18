package a189.轮转数组;


/**
 * 基于事实：数组向右翻转k后，后k%n个元素都在数组前面，前n-k%n个元素在数组后面
 * 假设        1 2 3 4 5 6 7  k=3,n=7
 * 全部翻转    7 6 5 4 3 2 1
 * 倒置前k个   5 6 7 4 3 2 1
 * 倒置后n-k个 5 6 7 1 2 3 4
 *
 * 时间：O(n)每个元素被翻转两次，共n个数组
 * 空间:（1）
 */
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k%n-1);
        reverse(nums,k%n,n-1);
    }
    void reverse(int[] nums,int i,int j){
        while (i<j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        solution.rotate(nums,k);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}