package a581.最短无序连续子数组;

/**
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * <p>
 * 把数组分为na,nb,nc 一定满足na的最大值小于nb和nc的最大值
 * 那么我们可以从左边找出一个数，使它小于nb和nc的最小值
 * 具体算法流程：
 * 用一个minn表示从右向左的最小值，如果有一个数大于当前minn，left记录其下标，
 * 那么最终left左边的数就都是小于右边的最小值，left即为要找二点numa与numb、numc的边界
 */
class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, minn = Integer.MAX_VALUE, maxn = Integer.MIN_VALUE, left = -1, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[n - i - 1] <= minn) {
                // 更新最小值
                minn = nums[n - i - 1];
            } else {
                // 说明当前数大于最小值，那么移动left,保证left的左边都是小于最小值
                left = n - i - 1;
            }
            if (nums[i] >= maxn) {
                // 更新最大值
                maxn = nums[i];
            } else {
                // 说明当前数大于最小值，那么移动left,保证left的左边都是小于最小值
                right = i;
            }
        }
        return left == -1 ? 0 : right - left + 1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 3, 3, 3};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
}