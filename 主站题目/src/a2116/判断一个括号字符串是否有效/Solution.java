package a2116.判断一个括号字符串是否有效;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 转换成 678. 有效的括号字符串 https://leetcode.cn/problems/valid-parenthesis-string/
 * * 括号匹配可以使用栈解决
 *  * 对于*号的情况，用例外的栈存储，当存储左括号（栈的情况时，用*号栈来代替
 *  * 最终如果栈（还有元素，也用*号栈来代替。注意此时*号的下标要大于‘（’对应的下标
 *  *
 *  * 时间：O（n）每个元素只进栈出栈一次
 *  * 空间：O（n）
 */
class Solution {
    public boolean canBeValid(String s, String locked) {
        Deque<Integer> stack1=new LinkedList<>();
        Deque<Integer> stack2=new LinkedList<>();

        for (int i = 0; i < locked.length(); i++) {
            char s1=s.charAt(i);
            char l1=locked.charAt(i);
            if(l1=='0'){ // 看作*，其他情况都是不能改变的
                stack2.addLast(i);
            } else if (s1=='(') {
                stack1.addLast(i);
            } else { // 只剩下右括号的情况了
                if(!stack1.isEmpty()){ // 优先使用左括号
                    stack1.removeLast();
                } else if (!stack2.isEmpty()) { // 再使用*的情况
                    stack2.removeLast();
                }else {
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
        return stack1.isEmpty()&&stack2.size()%2==0;
    }
}