package a1190.反转每对括号间的子串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 典型栈的应用
 * 对于非’）‘全部入栈，每次碰到’）‘，出栈找到’（‘,反转，再重新入栈
 * 重复操作，最终站就是目标字符串
 *
 * 时间：O（n^2）,最坏情况，右边都是），每遍历一个字符都要进栈出栈
 * 空间：O(n)
 *
 */
class Solution {
    public String reverseParentheses(String s) {
        Deque<Character> stack=new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c==')'){
                StringBuilder sb=new StringBuilder();
                while (stack.peekLast()!='('){
                    Character pop = stack.removeLast();
                    sb.append(pop); // 字符反转
                }
                stack.removeLast(); // ’(‘ 丢弃
                for (int j = 0; j < sb.length(); j++) {
                    stack.addLast(sb.charAt(j)); // 重新入栈
                }
            } else {
                stack.addLast(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseParentheses("12(3(789))"));
    }
}