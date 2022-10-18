package a128.最长连续序列;

import java.util.Arrays;

/**
 * 我这样虽然ac,但是一定不能排序，排序也改变了原数组的值
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,0,1};
        System.out.println(new Solution().longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }else if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        int max=1;
        int i=0,j=1;
        int cnt=0;
        for (; j < nums.length; j++) {
            if(nums[j]!=nums[j-1]&&nums[j]!=nums[j-1]+1){
                if(j-i-cnt>max){
                    max=j-i-cnt;
                }
                cnt=0;
                i=j;
            }else if(nums[j]==nums[j-1]){
                cnt++;
            }
        }
        if(j-i-cnt>max){
            max=j-i-cnt;
        }
        return max;
    }
}
