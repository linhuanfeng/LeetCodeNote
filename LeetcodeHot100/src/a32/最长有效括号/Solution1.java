package a32.最长有效括号;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 使用栈保存最后一个没有被匹配的右括号的下标
 * <p>
 * 第一个元素push -1，使满足以上规定
 * <p>
 * 对于（，把下标入栈
 * 对于），先出栈表示匹配了当前括号，再判断栈是否为空，
 * 为空说明当前）没法匹配，把下标入栈；
 * 不为空，说明匹配，当前下标-栈顶元素下标更更新最长有效括号匹配
 * <p>
 * (()))
 * <p>
 * ))()()
 * -1
 */
class Solution1 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else {
                stack.removeLast(); // 弹出和当前匹配的括号或更新最新的未匹配下标
                if (stack.isEmpty()) {
                    stack.addLast(i);  // 需要保持一个未匹配的下标
                } else {
                    res = Math.max(res, i - stack.peekLast());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().longestValidParentheses("(()"));
    }
}
