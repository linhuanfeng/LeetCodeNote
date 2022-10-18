package a45.跳跃游戏II;

/**
 * 贪心算法：
 * 每次更新当前能到达的最有价值边界，累加所有边界就是最少步数
 * <p>
 * 下标0可以到达下标1或下标2，
 * 但是下标1最大可以到达下标4，下标2最大可以下标3，所以选择本次边界为下标1
 * <p>
 * 比如
 * 数组           2,3,1,2,4,2,3
 * 下标           0 1 2 3 4 5 6
 * 最远下标       2 4 3 5 m       maxPosition
 * 当前边界       1 4     m
 * <p>
 * 从0开始遍历，找到当前边界的时候进行累加，并设置下一次边界，不断更新最远距离
 * <p>
 * 时间：O（n）
 * 空间：O(1)
 */
public class Solution3 {
    public int jump(int[] nums) {
        if(nums.length<2)return 0;
        int n = nums.length, maxPosition = 0, end = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            maxPosition = Math.max(i + nums[i], maxPosition);
            if (end == i) {
                // 到了当前边界，更新下一个边界
                end = maxPosition;
                ans++;
                if (end>=n-1){ // 到达最后的位置了
                    break;
                }
            }
        }
        return ans;
    }
}
