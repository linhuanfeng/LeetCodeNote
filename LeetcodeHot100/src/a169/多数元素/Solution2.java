package a169.多数元素;

import java.util.HashMap;
import java.util.Map;

/**
 * 分治：把数组分成两部分，众数一定至少是某一部分的众数，所以可用分治的思想
 *
 * 时间：O(nlogn)
 * 空间：O(logn) 递归的深度
 */
class Solution2 {
    public int majorityElement(int[] nums) {
        return fenZhi(nums,0,nums.length-1);
    }
    private int fenZhi(int[] nums,int left,int right){
        if(left==right)
            return nums[left];

        int mid=(left+right)/2;
        int left_res=fenZhi(nums,left,mid);
//        if(mid+1>right) return left_res; // 只有当元素个数为1的时候才会mid+1>right,但前面已经返回了
        int right_res=fenZhi(nums,mid+1,right);

        if(left_res==right_res)
            return left_res; // 左右两边众数相同，他肯定就是众数

        int leftCount = countNum(nums, left_res, left, right); // 统计各自出现的个数
        int rightCount = countNum(nums, right_res, left, right);
        return leftCount>rightCount?left_res:right_res;
    }
    private int countNum(int[] nums,int num,int left,int right){
        int count=0;
        for (int i = left; i <= right; i++) {
            if(num==nums[i])
                count++;
        }
        return count;
    }
}