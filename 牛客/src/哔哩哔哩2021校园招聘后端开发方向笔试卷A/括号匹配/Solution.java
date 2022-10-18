package 哔哩哔哩2021校园招聘后端开发方向笔试卷A.括号匹配;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

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
public class Solution {
    /**
     * 
     * @param s string字符串 
     * @return bool布尔型
     */
    public boolean IsValidExp (String s) {
        if("".equals(s))return true;
        // write code here
        Deque<Character> stack=new LinkedList<>();
        int n=s.length();
        for (int i = 0; i < n; i++) {
            Character c=s.charAt(i);
            if(c.equals('(')||c.equals('{')||c.equals('[')){
                stack.offerLast(c);
            }else {
                Character poll = stack.pollLast();
                if(poll==null)return false;
                if(c.equals(')')&&!poll.equals('(')){
                    return false;
                }else if(c.equals('}')&&!poll.equals('{')){
                    return false;
                }else if(c.equals(']')&&!poll.equals('[')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String expr="{[]}";
        System.out.println(solution.IsValidExp(expr));
    }
}