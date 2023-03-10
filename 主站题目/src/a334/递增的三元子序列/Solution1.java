package a334.递增的三元子序列;

/**
 * 二次遍历
 * nums[i]的左边存在一个数小于nums[i],等价于nums[i]的左边最小值小于nums[i]
 * 同理nums[i]的右边存在一个数大于nums[i],等价于nums[i]的左边最小值大于nums[i]
 * 因此，从左到右遍历，使用left[i]表示以第i个元素结尾的最小值
 *
 *   2 1 5 0 4 6
 * 0 1 2 3 4 5 6 7
 * - 2 1 1 0 0 0
 *   6 6 6 6 6 6
 *
 * 时间：O(n)
 * 空间：O(n)辅助数组
 *
 * {@link a673}
 */
class Solution1 {
    public boolean increasingTriplet(int[] nums) {
        int n= nums.length;
        int[] left=new int[n+2],right=new int[n+2]; // 增加左右边界，方便递推

        left[0]=Integer.MAX_VALUE;
        right[n+1]=Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            left[i]=Math.min(nums[i-1],left[i-1]);
            right[n-i+1]=Math.max(nums[n-i],right[n-i+2]);
        }
        for (int i = 1; i <=n ; i++) {
            if(nums[i-1]>left[i]&&nums[i-1]<right[i]){
                return true;
            }
        }
        return false;
    }
}
