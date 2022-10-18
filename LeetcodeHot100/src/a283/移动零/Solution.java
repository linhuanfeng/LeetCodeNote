package a283.移动零;

/**
 * 双指针
 */
class Solution {
    public void moveZeroes(int[] nums) {
        int p=0,q=0,n=nums.length; // p指向第一个0，q指向第一个非0
        while (p<n&&q<n){ // q越界说明后面已经没有0了，程序结束,p<n是防止数组没有0
            while (p<n&&nums[p]!=0)p++; // 找到右边第一个0
            q=p+1; // 只处理后面的
            while (q<n&&nums[q]==0)q++; // 找到右边第一个非0
            if(p<n&&q<n){ // q越界说明后面已经没有0了，程序结束,p<n是防止数组没有0
                swap(nums,p,q);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={1,0};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}