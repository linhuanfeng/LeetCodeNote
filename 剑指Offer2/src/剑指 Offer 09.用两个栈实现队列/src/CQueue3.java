import java.util.Deque;
import java.util.LinkedList;

/**
 * 优化
 */
public class CQueue3 {
    Deque<Integer> stack1;// 将双端队列当做堆栈来使用
    Deque<Integer> stack2;

    public CQueue3() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        CQueue3 cQueue = new CQueue3();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}


/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */