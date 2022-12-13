package a376.摆动序列;

/**
 * 贪心算法
 *
 * 滚动序列说明：波峰和波谷交替出现
 * 每次只统计第一个波峰或博谷，只保留局部的最优解
 * 比如
 * 3 7 11
 * 那么只能统计7
 *
 * 使用prevDiff保存之前的状态（差值）,
 * 使用curDiff保存当前结尾的状态（差值）
 * 那么就要满足波峰波谷这种规则，才可计数，同时更新之前的状态prevDiff
 *
 * 时间：O(n)
 * 空间：O(1)
 */
public class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int prevDiff=nums[1]-nums[0]; // 前一个的状态
        int res=prevDiff==0?1:2;
        for (int i = 2; i < nums.length; i++) {
            int curDiff=nums[i]-nums[i-1];
            if((prevDiff>=0&&curDiff<0)||(prevDiff<=0&&curDiff>0)){
                res++;
                prevDiff=curDiff;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new Solution2().wiggleMaxLength(
                new int[]{3,3,3,2,5}
        ));
    }
}
