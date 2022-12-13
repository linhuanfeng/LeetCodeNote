package a45.跳跃游戏II;

/**
 * 遍历当前可到达范围cover，得到下一次最远可到达的距离nextCover(也就是下一次的cover)
 * 如果cover达到最后位置，结束
 * <p>
 * 2,3,1,1,4
 * 6
 * <p>
 * 时间：O(n)
 * 空间：O(1)
 */
public class Solution4 {
    public int jump(int[] nums) {
        if(nums.length<2){
            return 0; // 默认在第一个位置，跳数为0
        }
        int cover = nums[0], nextCover = cover, res = 1;

        for (int i = 1; i <= cover; i++) {
            if ( cover >= nums.length - 1) { // 当前覆盖达到最后位置了，直接返回
                return res;
            }
            nextCover = Math.max(nextCover, i + nums[i]);
            if ( i == cover) { // 说明还不满足，探索下一个覆盖
                // 更新下一个cover
                res++;
                cover = nextCover;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution4().jump(
                new int[]{2,3,1,1,4}
        ));
    }
}
