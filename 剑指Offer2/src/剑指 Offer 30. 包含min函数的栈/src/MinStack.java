import java.util.Deque;
import java.util.LinkedList;

/**
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)
 * 空间复杂度：O(n)
 */
public class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2; // 递减辅助栈
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());  // -3
        minStack.pop();
        System.out.println(minStack.top());  // 0
        System.out.println(minStack.min());  // -2
    }
    /** initialize your data structure here. */
    public MinStack() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }

    public void push(int x) {
        stack1.push(x);
        // 待插入的元素x比stack2栈顶元素小,则可以插入stack2
        if(stack2.isEmpty()||(!stack2.isEmpty()&&stack2.peek()>=x)){
            stack2.push(x);
        }
    }

    public void pop() {
        int x=stack1.pop();
        // 保持两张表的一致性
        if(!stack2.isEmpty()&&stack2.peek()== x){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */