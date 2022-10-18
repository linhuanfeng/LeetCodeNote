package 剑指Offer59II.队列的最大值;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 均摊思想，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 说明一定要多开一个辅助双端队列，牺牲空间来换时间
 * 本算法的思想是：当前正常队列中小于最大值的元素对结果没有影响，所以只需要储较大值就行。
 *    双端队列队尾入队时，弹出队尾小于当前得元素得所有值，保证辅助队列时单调得
 *    另外注意当删除普通队列，判断双端队列对头是同一个，是则要出队
 *  时间复杂度：
 *  max_value为O(1)
 *  push_back 例如 543216，只有最后一次 push_back 操作是 O(n)，
 *      其他每次操作的时间复杂度都是 O(1)，均摊时间复杂度为
 *      (O(1)×(n−1)+O(n))/n=O(1)
 *  pop_front为O(1)
 *  空间复杂度：入队元素全是递减，则deque的长度为O(n)
 */
public class MaxQueue2 {
    Queue<Integer> queue=null;
    Deque<Integer> deque=null;
    public MaxQueue2() {
        queue=new ArrayDeque<>(); // 构建大根堆
        deque=new ArrayDeque<>();
    }

    public int max_value() {
        if(!deque.isEmpty()){
            return deque.peek();
        }else {
            return -1;
        }
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty()&&deque.peekLast()<value){
            // 从队尾开始，把比当前元素小的出队
            deque.pollLast();
        }
        deque.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            // 题目不会插入空，并且插入空会报空指针异常
            return -1;
        }
        // queue不为空，deque也不为空
        if(queue.peek().equals(deque.peekFirst())){
            // 出队元素是双端队列的队头的话，那么双端队列也要出队
            deque.poll();
        }
        return queue.poll();
    }
}
