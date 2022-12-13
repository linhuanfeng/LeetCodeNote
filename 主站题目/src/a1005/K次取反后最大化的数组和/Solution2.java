package a1005.K次取反后最大化的数组和;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 贪心+排序
 *
 * 4 3  -2 -2  1
 * 按绝对值逆序排序，先对所有的负数进行修改，如果都变成正数了，那么只需再修改最后一个数一次或0次
 *
 *
 * 从左到右对负数进行修改，保证了修改价值最大的数
 * 同时需要注意，如果都变成正数了，那么需要对最小的正数进行修改
 * 由于是按绝对值排序的，那么最小的正数就是最后一个
 *
 * 时间：O(nlogn) 排序的消耗
 * 空间：O(n)
 *
 * 这里其实用了两次贪心！
 *
 * 第一次贪心：局部最优：让绝对值大的负数变为正数，当前数值达到最大，
 * 整体最优：整个数组和达到最大。
 * 处理之后，如果K依然大于0，此时的问题是一个有序正整数序列，如何转变K次正负，让 数组和 达到最大。
 *
 * 第二次贪心：局部最优：只找数值最小的正整数进行反转，当前数值可以达到最大（例如
 * 正整数数组{5, 3, 1}，反转1 得到-1 比 反转5得到的-5 大多了），全局最优：整个 数组和 达到最大。
 *
 * 贪心算法：K次取反后最大化的数组和 (opens new window)中的代码，最后while处理K的时候，
 * 其实直接判断奇偶数就可以了，文中给出的方式太粗暴了，哈哈，Carl大意了。
 */
class Solution2 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序
        nums = IntStream.of(nums).
                boxed(). // 装箱
                        sorted((a,b)->Math.abs(b)-Math.abs(a)).
                mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
        }
        if(k>0&&k%2==1){
            nums[nums.length-1]=-nums[nums.length-1];
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().largestSumAfterKNegations(
                new int[]{-8,3,-5,-3,-5,-2}, 6
        ));
    }
}