package a283.移动零;

/**
 * 双指针
 */
class Solution2 {
    public void moveZeroes(int[] nums) {
        int left=0,right=0,n=nums.length; // p指向第一个0，q指向第一个非0
        while (right<n){
            if(nums[right]!=0){ // 右指针指向第一个非0，保证左指针指向0
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={1,0};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}