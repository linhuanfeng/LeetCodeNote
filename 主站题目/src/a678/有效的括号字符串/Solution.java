package a678.有效的括号字符串;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 括号匹配可以使用栈解决
 * 对于*号的情况，用例外的栈存储，当存储左括号（栈的情况时，用*号栈来代替
 * 最终如果栈（还有元素，也用*号栈来代替。注意此时*号的下标要大于‘（’对应的下标
 *
 * 时间：O（n）每个元素只进栈出栈一次
 * 空间：O（n）
 */
class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> stack1=new LinkedList<>(),stack2=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('){
                stack1.addLast(i);
            } else if (c=='*') {
                stack2.addLast(i);
            }else {
                if(!stack1.isEmpty()){ // 优先左括号进行匹配
                    stack1.removeLast();
                }else if(!stack2.isEmpty()){ // 左括号为空，把*当作左括号进行匹配
                    stack2.removeLast();
                }else { // 匹配失败
                    return false;
                }
            }
        }
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            Integer left = stack1.removeLast();
            Integer right = stack2.removeLast();
            if(left>right){
                return false;
            }
        }
        return stack1.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkValidString(
                "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }
}