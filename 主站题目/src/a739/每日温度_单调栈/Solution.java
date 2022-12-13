package a739.每日温度_单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 * <p>
 * 维护一个单调递减栈,元素是下标
 * <p>
 * 时间：O(n)每个元素最多入栈和出栈一次
 * 空间：O(n)栈临时存储元素
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.getLast()] < temperatures[i]) {
                Integer last = stack.removeLast();
                res[last] = i - last;
            }
            stack.addLast(i);
        }
        return res;
    }
}