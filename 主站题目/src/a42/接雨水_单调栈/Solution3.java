package a42.接雨水_单调栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 *
 * 维护一个递减的单调栈
 * 遍历i,每次能接到雨水，那么栈中至少有两个元素
 * 记栈顶元素为top,下一个元素是left
 * 接的雨水就为：（min(h[left],h[i])-h[top]）*(i-left)
 * 然后，left就变成新的top.重新上面的步骤
 *
 * 9
 *
 * 4,2,0,3,2,5
 *
 * 时间：O(n) 每个元素入栈出栈一次
 * 空间：O(n)
 */
class Solution3 {
    public int trap(int[] height) {
        Deque<Integer> stack=new LinkedList<>();
        int res=0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty()&&height[stack.getLast()]<height[i]){
                int top = stack.removeLast(); // 栈顶作为2容器底部
                if(stack.isEmpty()){
                    break; // 左边没有墙，无法拦截雨水
                }
                int left=stack.getLast(); // 容器左边界
                res+=(Math.min(height[i],height[left])-height[top])*(i-left-1);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().trap(
                new int[]{4,2,0,3,2,5}
        ));
    }
}
