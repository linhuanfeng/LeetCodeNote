package a394.字符串解码;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助栈处理
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * "100[leetcode]"
 * "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetco
 *
 * 算法思想： 两个辅助栈，stack_multi存上一次倍数，stack_res存上一次结果,multi存放当前倍数，res存放最终结果（不断更新）
 *  遇到数字，multi记录当前数字
 *  遇到'[',stack_multi.add(multi),stack_res.add(res),res和multi重置
 *  遇到']',stack_multi和stack_res都出栈，具体是stack_res.remove+stack_multi.remove*res
 *
 */
class Solution {
    public String decodeString(String s) {
        Deque<Integer> stack_multi=new LinkedList<>(); // 存放上一次倍数
        Deque<String> stack_res=new LinkedList<>(); // 存上一次结果
        int multi=0; // 存放当前结果
        StringBuilder res=new StringBuilder(); // 最终的结果
        for (char c : s.toCharArray()) {
            if(c>='0'&&c<='9'){
                multi=multi*10+(c-'0'); // 记录当前倍数
            }else if(c=='['){
                stack_multi.add(multi); // 倍数和临时结果入栈，等待下一个']'再出栈
                stack_res.add(res.toString());
                // 遇到'['都重新计数
                res=new StringBuilder();
                multi=0;
            }else if(c==']'){
                Integer before_multi = stack_multi.removeLast();
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < before_multi; i++) {
                    tmp.append(res);                    // 当前倍数*当前结果
                }
                res=new StringBuilder(stack_res.removeLast()+tmp); // 上一次的结果加上当前的结果
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String deco="100[leetcode]";
        System.out.println(solution.decodeString(deco));
    }
}