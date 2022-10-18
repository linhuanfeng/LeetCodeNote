package a581.最短无序连续子数组;

import java.util.Arrays;

/**
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 先排序，再进行左右端点的比较
 * 时间：O(nlogn),需要双端快排进行排序
 * 空间：O（n） 新开的数组
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] newNums=Arrays.copyOf(nums,n);
        Arrays.sort(newNums);
        int i=0,j=n-1;
        while (i<n&&nums[i]==newNums[i])i++;
        while (i<j&&j>0&&nums[j]==newNums[j])j--;
        if(i>=j)return 0;
        else return j-i+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,6};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}