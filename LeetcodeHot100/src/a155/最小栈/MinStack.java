package a155.最小栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 辅助最小栈保持单调
 */
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack=new LinkedList<>();
        minStack=new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if(minStack.isEmpty())
            minStack.addLast(val);
        else if(val<=minStack.getLast())
            minStack.addLast(val);
    }
    
    public void pop() {
        Integer last = stack.removeLast();
        if(minStack.getLast().equals(last)) // 注意使用equals
            minStack.removeLast();
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}