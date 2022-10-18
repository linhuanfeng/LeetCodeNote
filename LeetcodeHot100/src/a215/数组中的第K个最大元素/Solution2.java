package a215.数组中的第K个最大元素;

/**
 * 快排变体:哨兵位置i就是第n-i大的数
 * 时间：O(n) 最差每次就确定1 n-1
 * 空间：O(1)
 */
class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,k,0,nums.length-1);
    }
    private int quickSort(int[] nums,int k,int left,int right){
        int i=left,j=right;
        int key=nums[i];
        while (i<j){
            while (i<j&&nums[j]>=key){
                j--;
            }
            if(j>i){
                nums[i]=nums[j];
                i++;
            }
            while (i<j&&nums[i]<=key){
                i++;
            }
            if(j>i){
                nums[j]=nums[i];
                j--;
            }
        }
        nums[i]=key;
        int index=nums.length-k;
        if(i==index){
            return nums[i];
        }else if(i>index){
            return quickSort(nums, k, left, i-1);
        }else {
            return quickSort(nums, k, i+1, right);
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));

    }
}