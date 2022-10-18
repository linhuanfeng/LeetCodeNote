import javax.crypto.spec.PSource;
import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {
    public static void main(String[] args) {
        // 双端队列测试
        Deque<Integer> stack=new LinkedList<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek()); // 栈顶元素 或返回null  2
        System.out.println(stack.poll()); // 出栈  2
//        System.out.println(stack.pop());  // 出栈 会抛出异常

        System.out.println("==================");
        stack.push(3);
        System.out.println(stack.peek()==3);  // true  容器有点不同
        stack.push(1000);
        System.out.println(stack.peek()==1000);  // true

        System.out.println("==================");
        Integer a1=100,b1=100;
        System.out.println(a1==b1);  // true 基本数据类型的3和包装3是相等的 因为是缓存池【-128，127】是在缓存中的
        Integer a2=128,b2=128;
        System.out.println(a2==b2);  // false

        System.out.println("==================");
        stack.clear();
        stack.offer(null);
        System.out.println(stack.isEmpty()); // false 说明null值可以插进去
    }
}
