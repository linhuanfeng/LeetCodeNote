package a31.下一个排列;

/**
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 从右向左找到第一个非递增元素num[i]
        // 从右向左找到第一个大于num[i]的nums[j] j>i
        // 交换num[i]和num[j],[i+1,n]进行反转
        int n=nums.length,i=-1,j=-1;
        for (int k = n-2; k >=0 ; k--) {
            if(nums[k]<nums[k+1]){ // 右到左找到第一个递增序列，即将左边较小的数和右边较大的数交换
                i=k;
                break;
            }
        }
        if(i==-1){
            // 说明是尽头了
            reverse(nums,0,n-1);
            return;
        }
        for (int k = n-1; k >i ; k--) {
            if(nums[k]>nums[i]){ // 从n-1到i+1找到第一个大于num[i]的数,进行交换
                j=k;
                break;
            }
        }
        swap(nums,i,j);
        reverse(nums,i+1,n-1); // 对i+1之后的数进行升序排序，保证是下一个排列
    }
    void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    void reverse(int[] nums,int i,int j){
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,3,1};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}