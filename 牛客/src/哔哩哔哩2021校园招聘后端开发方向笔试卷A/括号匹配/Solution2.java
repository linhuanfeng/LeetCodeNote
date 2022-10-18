package 哔哩哔哩2021校园招聘后端开发方向笔试卷A.括号匹配;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包含括号的字符串，判断字符串是否有效。其中，括号种类包含： ‘(’，’)’，’{’，’}’，’[’，’]'。有效字符串需满足：1) 左括号必须用相同类型的右括号闭合；2）左括号必须以正确的顺序闭合。注意空字符串可被认为是有效字符串
 *
 * 输入例子1:
 * "{[]}"
 *
 * 输出例子1:
 * true
 *
 * 输入例子2:
 * "([)]"
 *
 * 输出例子2:
 * false
 *
 * 输入例子3:
 * "([]"
 *
 * 输出例子3:
 * false
 */
public class Solution2 {
    /**
     * 
     * @param s string字符串 
     * @return bool布尔型
     */
    public boolean IsValidExp (String s) {
        if("".equals(s))return true;
        // write code here
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='{')stack.push('}');
            else if(s.charAt(i)=='[')stack.push(']');
            else if(s.charAt(i)=='(')stack.push(')');
            else {
                if(stack.isEmpty()||!stack.pop().equals(s.charAt(i)))return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String expr="{[]}";
        System.out.println(solution.IsValidExp(expr));
    }
}