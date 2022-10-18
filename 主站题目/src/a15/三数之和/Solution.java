package a15.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 先排序，再使用双指针.
 * 前后相同要跳过以去重
 * 时间：O(n^2)
 * 空间：O(1)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue; // 去重，因为前后相同，会导致重复三元组
            }
            int left = i + 1, right=n-1;
            while (left<right){
                int total=nums[i]+nums[left]+nums[right];
                if(total==0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重，和前一个相同则跳过，不然产生重复组
                    while (++left<right&&nums[left]==nums[left-1]){}
                    while (--right>left&&nums[right]==nums[right+1]){}
                } else if (total>0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution2 = new Solution();
        System.out.println(solution2.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
