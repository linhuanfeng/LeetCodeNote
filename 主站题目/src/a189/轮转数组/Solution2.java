package a189.轮转数组;


/**
 * 使用额外的数组
 * 时间：O(n)每个元素被翻转两次，共n个数组
 * 空间:（1）
 */
class Solution2 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] newArr=new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i+k)%n]=nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        solution.rotate(nums,k);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}