package a19.删除链表的倒数第N个结点.有效的括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 括号匹配肯定要用到栈
 * 输入：s = "([)]"
 * 输出：false
 * 输入：s = "{[]}"
 * 输出：true
 * 时间：O(n)s.length()变量一遍
 * 空间：临时存放做括号的栈，不大于s.length
 */
class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map=new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        Deque<Character> stack=new LinkedList<>();
        stack.push(s.charAt(0));
        for (int i=1;i<s.length();i++){
            if(isLeft(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                if(!stack.isEmpty()&&stack.pop()==map.get(s.charAt(i)).charValue()){
                }else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
    boolean isLeft(char c){
        if(c=='['||c=='{'||c=='('){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("{()}"));
    }
}