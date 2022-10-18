package a75.颜色分类;

/**
 * nlogn
 * 错误
 */
class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }
    void quickSort(int[] nums,int left,int right){
        int i=left,j=right,key=nums[left];
        while (i<j){
            while (i<j&&nums[j]>=key)j--;
            if(i!=j){
                nums[i]=nums[j];
                i++;
            }
            while (i<j&&nums[i]<=key)i++;
            if(i!=j){
                nums[j]=nums[i];
                j--;
            }
        }
        nums[i]=key;
        if(i-1>left)quickSort(nums,left,j-1);
        if(i+1<right)quickSort(nums,i+1,right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,0,1};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}