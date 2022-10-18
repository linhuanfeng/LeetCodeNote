import java.util.ArrayList;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        int[] temperatures ={30,60,90};
        int[] res = dailyTemperatures(temperatures);
        for (int i : res) {
            System.out.print(i+" ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        int res[]=new int[len];

        // ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        // {73,74,75,71,69,72,76,73}
        for (int i=0 ;i< temperatures.length;i++) {
                // 找到栈顶元素的升温日,则出栈，继续判断下一个栈顶元素，直到栈为空或者当前元素小于等于栈顶元素退出循环
            while(!stack.empty()&&temperatures[i]>temperatures[stack.peek()]){
                int t = stack.pop();
                res[t] = i - t;
                // break;
            }
            stack.push(i);
        }
        return res;
    }
}
