package 剑指Offer31.栈的压入弹出序列;

import java.util.LinkedList;

/**
 * 栈模拟+指针
 * 时间：O(n) 每个元素最多进栈和出栈一次
 * 空间：O(n) 栈的最大开销
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = pushed.length;
        int i = 0, j = 0;
        // i可以等于pushed.length，因为栈只要不为空就可以和popped继续匹配
        while (i <= n && j < n) {
            if (!stack.isEmpty() && stack.getLast() == popped[j]) { // 栈顶匹配成功，出栈
                stack.removeLast();
                j++;
            } else if(i==n){ // 栈顶匹配失败且入栈序列已用完，说明不是压入弹出序列
                break;
            }else {
                stack.addLast(pushed[i++]); // 匹配失败，入栈尝试下一次匹配
            }
        }
        if (stack.isEmpty() && j == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(
                new int[]{1, 2, 3, 4, 5}, new int[]{4, 3,5,1,2}));
    }
}

