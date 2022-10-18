import java.util.Deque;
import java.util.LinkedList;

public class CQueue2 {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue2() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();

    }

    public void appendTail(int value) {
        while (stack2.size()!=0){           // 不一定每次都要把元素都移到栈2去
            stack1.push(stack2.pollLast());
        }
        stack1.push(value);
    }

    public int deleteHead() {
        while (stack1.size()!=0){
            stack2.push(stack1.pollLast());
        }
        if(stack2.size()==0){
            return -1;
        }
        return stack2.poll();
    }

    public static void main(String[] args) {
        CQueue2 cQueue = new CQueue2();
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