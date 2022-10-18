package a84.柱状图中最大的矩形;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 找到当前高度左边第一个小于当前高度的柱子，和右边第一个小于当前高度的柱子
 * 这就是单调栈的典型应用
 * 时间：O(n)，每个元素只进出一次栈，所以为O（n）
 * 空间：O(n)
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int max = 0,n=heights.length;
        int[] left=new int[n],right=new int[n]; // 分别表示当前数的左边和右边第一个小于当前高度的柱子下标

        for (int i = 0; i < heights.length; i++) {
            while ((!stack.isEmpty() && heights[stack.peekLast()] >= heights[i])) {
                // 栈顶比当前数大则出栈,只关心第一个比自己小的柱子，比自己大的不影响当前矩形的高度，维护单调
                stack.removeLast();
            }
            // 此时栈顶元素就是左边第一个小于当前高度的柱子
            left[i]=stack.isEmpty()?-1:stack.peekLast();
            stack.addLast(i);
        }
        stack.clear(); // 栈记得重新清空
        // 同理找到右边第一个小于当前高度的柱子
        for (int i = n-1; i >=0; i--) {
            while ((!stack.isEmpty() && heights[stack.peekLast()] >= heights[i])) {
                stack.removeLast();
            }
            right[i]=stack.isEmpty()?n:stack.peekLast();
            stack.addLast(i);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max, heights[i]*(right[i]-left[i]-1));
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,4}));
    }
}