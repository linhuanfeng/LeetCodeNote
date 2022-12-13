package a134.加油站;

/**
 * 尝试贪心算法
 * 审题，就是01234环路骑行，不能跳跃,比如310
 *
 *       0    1    2    3   4
 * gas   1    2    3    4   5
 * cost  3    4    5    1   2
 * rest -2   -2   -2   3   3
 *
 * sum+=rest
 *
 * 所有加油站的总油量大于总消耗(sum>=0)，那么就可以跑完全程？
 * 使用curSum记录从j(初始为0)开始到当前加油站i的剩余值，
 * 如果curSum<0，说明以j开始不能跑完全程，更新j=i+1
 * 否则j就是最终值
 *
 * 时间：O（n）
 * 空间：O(1)
 *
 * https://leetcode.cn/problems/gas-station/solutions/1537344/by-nehzil-nnws/
 * https://programmercarl.com/0134.%E5%8A%A0%E6%B2%B9%E7%AB%99.html#%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95-%E6%96%B9%E6%B3%95%E4%BA%8C
 *
 * 5, 1,2, 3,4
 * 4, 4,1, 5,1
 * 1 -3 1 -2 3
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum=0,sum=0,j=0;

        for (int i = 0; i < gas.length; i++) {
            int rest=gas[i]-cost[i];
            curSum+=rest;
            sum+=rest;
            if(curSum<0){
                curSum=0;
                j=i+1;
            }
        }
        if(sum<0){
            return -1;
        }
        return j;
    }
}