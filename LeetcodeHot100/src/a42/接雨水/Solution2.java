package a42.接雨水;

import java.util.LinkedList;

/**
 * 单调栈
 * 维护一个单调不递增的栈
 * 对于栈中元素left,top，height[left]>left[top],如果当前i满足
 * height[i]>height[top],且栈中元素至少两个，那么可以蓄水
 * <p>
 * 时间：O(n)
 * 空间：O(n)
 */
class Solution2 {
    public int trap(int[] height) {
        int n = height.length, ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.getLast()]) {
                // 递增了就要重新维护，等价于满足了蓄水的条件
                Integer top = stack.removeLast();
                if (stack.isEmpty()) {
                    break;
                }
                Integer left = stack.getLast();
                ans += (i - left-1) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.addLast(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}