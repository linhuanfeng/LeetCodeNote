public class Solution {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        Solution solution = new Solution();
        System.out.println(solution.search(nums, 8));
    }
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int res=0;
        // 搜索右边界 找出第一个比target大的数
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<=target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        int right=i;

        // 不要思维固化，你想怎么实现就怎么实现，后面再改
        i=0;
        // 找到第一个比它小的
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]<target){
                // 说明为当前数或者右边的数
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        int left=j;

        return right-left-1;
    }
}
