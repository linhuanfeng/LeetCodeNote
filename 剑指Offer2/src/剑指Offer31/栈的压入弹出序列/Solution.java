package 剑指Offer31.栈的压入弹出序列;

import java.util.LinkedList;

/**
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 时间复杂度：o(n)
 * 空间复杂度：0(n)
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0){
            return true;
        }
        // 辅助队列 用来模拟出入栈，若栈为空则为true
        LinkedList<Integer> stack = new LinkedList<>();
        int i=1,j=0;
        stack.push(pushed[0]);
        while (j<popped.length&&i<=pushed.length) {
            //
            if(!stack.isEmpty()&&stack.peek()==popped[j]){
                // 防止空指针异常 integer==int 会调用intval报空指针异常
                j++;
                stack.pop();
            }else {
                if(i==pushed.length){
                    break;
                }
                stack.push(pushed[i++]);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,0},
                popped = {1,0};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}