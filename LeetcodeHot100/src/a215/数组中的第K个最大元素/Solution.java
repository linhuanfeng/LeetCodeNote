package a215.数组中的第K个最大元素;

/**
 * 初步考虑：使用大根堆排序
 * 时间：O(nlogn)
 * 空间：O(1)
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length-1;
        for (int i = 0; i < k; i++) {
            int last=n-i;
            adjust(nums,last);
            swap(nums,0,last);
        }
        return nums[n-k+1];
    }
    private void adjust(int[] nums,int n){
        for (int i = (n-1)/2; i >=0 ; i--) {
            int t=nums[i],j=i;
            while (j*2+1<=n){
                int m=2*j+1;
                if(m+1<=n&&nums[m+1]>nums[m]) // 选较大的孩子
                    m++;
                if(nums[m]>t){ // 比t大的上移
                    nums[j]=nums[m];
                    j=m;
                }else {
                    nums[j]=t; // 没有比t大的数了，即找到t的位置，退出循环
                    break;
                }
            }
            nums[j]=t;
        }
    }
    private void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={3,2,1,5,6,4};
        System.out.println(solution.findKthLargest(nums, 2));

    }
}