package a376.摆动序列;

/**
 *       3 3 5
 * up    1 1 2
 * down  1
 *
 * up[i]记录前i个元素中上升摆动序列的最大长度，比如1 2 3 4
 * down记录前i个元素中下降摆动序列的最大长度，比如4 3 2 1
 *
 *
 * 如果当前是上升，即nums[i]>nums[i-1],
 *     那么对up[i-1]没有贡献，up[i]=up[i-1]
 *
 */
public class Solution3 {

    public int wiggleMaxLength(int[] nums) {
        return 0;
    }

//    var wiggleMaxLength_2 = function (nums) {
//	const n = nums.length;
//        if (n < 2) return n;
//        //! up[i] 记录以i截止的上升摆动的最大长度
//	const up = new Array(n).fill(0);
//        //! down[i] 记录以i截止的下降摆动的最大长度
//	const down = new Array(n).fill(0);
//        up[0] = down[0] = 1;
//        for (let i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                //! 上升摆动：
//                //情况1：连续的上升，不用当前元素，沿用之前的上升摆动长度值
//                //情况2：下降过程，从上一个下降摆动过来 + 当前元素 成为上升摆动
//                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
//
//                //! 此过程是上升摆动，所以下降摆动未变化，所以沿用之前的值
//                down[i] = down[i - 1];
//            } else if (nums[i] < nums[i - 1]) {
//                //! 下降摆动：
//                //情况1：连续的下降，不用当前元素，沿用之前的下降摆动长度
//                //情况2: 下降过程，由上一个上升摆动过来 + 当前元素 成为下降摆动
//                down[i] = Math.max(down[i - 1], up[i - 1] + 1);
//                //! 此过程是下降摆动，所以上升摆动未变化，所以沿用之前的值
//                up[i] = up[i - 1];
//            } else {
//                //!既不是上升也不是下降，直接沿用直接的值
//                up[i] = up[i - 1];
//                down[i] = down[i - 1];
//            }
//        }
//        return Math.max(up[n - 1], down[n - 1]);
//    };
}
