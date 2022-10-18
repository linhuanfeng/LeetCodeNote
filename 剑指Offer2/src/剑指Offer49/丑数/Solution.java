package 剑指Offer49.丑数;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 采用堆实现
 * topK,第k个元素，中位数，都可以采用堆实现
 *
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。1也算
 * 求按从小到大的顺序的第 n 个丑数。
 */
class Solution {
    public int nthUglyNumber(int n) {
        // 取第几大元素，可用堆实现，
        PriorityQueue<Long> heap = new PriorityQueue<>(); //注意会越界
        Set<Integer> set = new HashSet<>();// 用来去重
        int[] factors={2,3,5};// 因子
        heap.add(1L);
        set.add(1);
        int ugly=0;
        for (int i = 1; i <= n; i++) {
            ugly=heap.poll().intValue();
            for (int factor:  factors) {
                if(set.add(ugly*factor)){
                    // 因为重复会返回false
                    heap.add(1L*ugly*factor);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 10 11 12
        // 12 15
        System.out.println(solution.nthUglyNumber(11));
    }
}