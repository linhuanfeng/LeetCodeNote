package a32.最长有效括号;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 使用栈保存最后一个没有匹配的下标
 * 第一个元素push -1，使满足以上规定
 * 对于（，把下标入栈
 * 对于），出栈，计算当前括号的最大值，如果栈为空
 *
 * (()))
 *
 *
 * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，
 * 这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
 *
 * 对于遇到的每个 ( ，我们将它的下标放入栈中
 * 对于遇到的每个 ) ，我们先弹出栈顶元素表示匹配了当前右括号：
 *      如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到
 *          的「最后一个没有被匹配的右括号的下标」
 *      如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
 *          我们从前往后遍历字符串并更新答案即可。
 *
 * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及
 *      的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 -1 的元素。
 *
 *
 */
class Solution2 {
    public int longestValidParentheses(String s) {
        int n=s.length();
        Deque<Integer> stack=new LinkedList<>();
        stack.push(-1); //边界处理
        int ans=0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                // 表示匹配到了
                stack.pop();
                if(stack.isEmpty()){
                    // 为空,始终保持栈顶为最后一个未被匹配的）
                    stack.push(i);
                }else {
                    ans=Math.max(ans,i-stack.peek());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.longestValidParentheses("()(()"));
    }
}