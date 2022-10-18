package a301.删除无效的括号;

import java.util.*;

/**
 * 题目要求返回所有可能的结果，那么只能使用dfs或bfs遍历所有可能的情况
 * 首先，找到最少需要删除左括号数和右括号数，然后尝试删除所括号或右括号
 *
 * 时间：n*2^n 遍历一遍n，每次还要两次递归调用2^n
 * 空间：n^2 栈深度，每次需要复制字符串一次
 */
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int leftRemove=0,rightRemove=0; // 左右括号最少需要删除的个数，那么实际只能删除大于等于该数目，因此可作为边界条件
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                leftRemove++;
            }else if(s.charAt(i)==')'){ // 注意还可能包含字母
                if(leftRemove>0){
                    leftRemove--; // 和左括号匹配，左括号不需要移除
                } else{
                    rightRemove++; // 没有匹配的左括号，右括号需要移除，所以加一
                }
            }
        }
        helper(s,0,leftRemove,rightRemove);
        return ans;
    }

    void helper(String s,int start,int leftRemove,int rightRemove){
        if(leftRemove==0&&rightRemove==0){
            // 判断当前字符串是否需要合法
            if(isValid(s)){
                ans.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if(i!=start&&s.charAt(i)==s.charAt(i-1)){
                continue; // 跟上一个元素一样，且能到这里说明上一个元素没进入递归，那么这个元素也不用进入下面的判断
            }
            if(leftRemove+rightRemove>s.length()-i){
                return; // 后面的字符数还小于需要删除的左右删除个数，肯定不符合
            }
            // 尝试删除左括号
            if(s.charAt(i)=='('&&leftRemove>0){//  注意下标从i开始，因为i被删除，在新串还是从i位置开始   回溯记得不能是--
                helper(s.substring(0,i)+s.substring(i+1),i,leftRemove-1,rightRemove);
            }
            if(s.charAt(i)==')'&&rightRemove>0){
                helper(s.substring(0,i)+s.substring(i+1),i,leftRemove,rightRemove-1);
            }
        }
    }
    boolean isValid(String s){
        int leftCount=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                leftCount++;
            }else if(s.charAt(i)==')'){ // 注意还可能是字母
                if(leftCount==0){
                    return false;
                }else {
                    leftCount--;
                }
            }
        }
        return leftCount==0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (String s : solution.removeInvalidParentheses(")(")) {
            System.out.println(s);
        }
    }
}