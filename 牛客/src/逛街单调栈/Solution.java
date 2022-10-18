package 逛街单调栈;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.nowcoder.com/questionTerminal/58ae39f4436b44d9836fc89542d67f71
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 * 小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处
 * 能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 * 输入
 * [5,3,8,3,2,5]
 * 输出
 * [3,3,5,4,4,4]
 */
public class Solution {
    /**
     * 两个单调栈，
     *      栈1中的数据都是非递增
     *      栈1中的数据都是非递减
     */
    public int[] findBuilding (int[] heights) {
        // write code here
        int n=heights.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        Deque<Integer> stack1=new LinkedList<>();
        for (int i = 0; i <n-1 ; i++) {
            while (!stack1.isEmpty()&&stack1.peek()<=heights[i]){
                // 栈顶元素小于等于当前元素heights[i]，说明会被挡到，出栈
                stack1.pop();
            }
            stack1.push(heights[i]);
            // 此时栈中的元素都是大于等于heights[i]，所以heights[i+1]都能看到，也就是前面能看到的楼
            ans[i+1]+=stack1.size();
        }
        Deque<Integer> stack2=new LinkedList<>();
        for (int i = n-1; i >0 ; i--) {
            while (!stack2.isEmpty()&&stack2.peek()<=heights[i]){
                // 栈顶元素小于等于当前元素heights[i]，说明会被挡到，出栈
                stack2.pop();
            }
            stack2.push(heights[i]);
            // 此时栈中的元素都是大于等于heights[i]，所以heights[i+1]都能看到，也就是前面能看到的楼
            ans[i-1]+=stack2.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr={5,3,8,3,2,5};
        int[] building = solution.findBuilding(arr);
        for (int i : building) {
            System.out.print(i+" ");
        }
    }
}
