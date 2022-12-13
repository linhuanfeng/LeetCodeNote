package 剑指Offer31.栈的压入弹出序列;

import java.util.LinkedList;

/**
 * 栈模拟+指针
 * 1 2 3 4 5       4 5 3 2 1
 */
public class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        stack.addLast(pushed[i++]);
        // i可以等于pushed.length，因为栈只要不为空就可以和popped继续匹配
        while (i<=pushed.length||j< popped.length){
            if(!stack.isEmpty()&&stack.getLast()==popped[j]){
                stack.removeLast(); // 匹配到出栈
                j++;
            }else {
                // 匹配失败，尝试入栈
                if(i==pushed.length){
                    // 用完了无法再匹配，失败退出
                    break;
                }
                stack.addLast(pushed[i++]);
            }
        }
        return stack.isEmpty();
    }
}