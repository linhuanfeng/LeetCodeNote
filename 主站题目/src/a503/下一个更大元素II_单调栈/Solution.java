package a503.下一个更大元素II_单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 *
 * 递减的单调栈，每次不符合就可以开始赋值了
 * 存下标
 *
 * n=5
 *
 * 5 6 7 8 9
 * 0 1 2 3 4
 *
 * 1,2,3,4,3
 *
 * 输出: [2,3,4,-1,4]
 *
 * 时间：O(n) 每个元素最多入栈出栈一次
 * 代码：O(n)
 */
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack=new LinkedList<>();
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);

        for (int i = 0; i < nums.length*2; i++) {
            while (!stack.isEmpty()&&nums[stack.getLast()%nums.length]<nums[i% nums.length]){
                Integer last = stack.removeLast();
                res[last% nums.length]=nums[i% nums.length];
            }
            stack.addLast(i);
        }
        return res;
    }
}