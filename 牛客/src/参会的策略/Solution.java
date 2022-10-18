package 参会的策略;

import java.util.*;

/**
 * 贪心，按照回忆结束时间排序，如果能参加就参加
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param times int整型二维数组 
     * @return int整型
     */
    public int AttendMeetings (int[][] times) { // 贪心算法
        Arrays.sort(times,(a,b)->a[1]-b[1]); // 按会议结束排序
        int ans=1,lastEnd=times[0][1];
        for (int i = 1; i < times.length; i++) {
            if(times[i][0]>=lastEnd){ // 如果在前一次结束之前能参会，那么直接参会
                ans++;
                lastEnd=times[i][1]; // 修改最后一次的结束时间，因为闪一次会议不一定会参加
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times={{8,12},{10,11},{11,12}};
        System.out.println(solution.AttendMeetings(times));

    }
}