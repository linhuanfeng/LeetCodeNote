package a435.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心+排序
 *
 *
 * 一、按左区间进行排序（错误）
 * 使用left，right保留上一次的左右边界，
 * 如果当前和left，right重复，则删除当前,给右边留更多的区间
 * 否则更新left，right
 *
 * 上面贪心策略的反例：
 * 假设第一个跨度很大，那么第一个更应该删除，比如
 * 1，        29
 *  2，3
 *     3，4
 *
 * 二、按右区间进行排序（正确）
 * 改变贪心策略，假设按第二位进行排序，其它步骤一样
 * 保证当前的右边界尽可能小，那么后面就可以留下更多的区间
 * 就是会议预约问题，保留最快结束的会议
 *  2，3
 *     3，4
 * 1，        29
 *
 *
 * [1,2],[2,3],[3,4],[1,3]
 * 1,2
 * 1,  3
 *  2, 3
 *     3,4
 *
 *
 * 时间：O(nlogn)快排
 * 空间：O(log2n) 递归栈的空间
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 按第二位升序
        Arrays.sort(intervals,
                (a,b)->{
            return a[1]==b[1]?0:(a[1]>b[1]?1:-1);}
                );

        // 按第一位升序，第二位升序
//        Arrays.sort(intervals,
//                (a,b)->{
//                    if(a[0]!=b[0]){return a[0]>b[0]?1:-1;}
//                    else {return a[1]==b[1]?0:(a[1]>b[1]?1:-1);}
//                });

        int right=intervals[0][1],count=0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]<right){
                count++; // 当前删除
            }else {
                right=intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().eraseOverlapIntervals(
//                new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}
//                new int[][]{{1,2},{1,3},{2,3},{3,4}}
                new int[][]{{2,3},{3,4},{1,29}}
        ));
    }
}