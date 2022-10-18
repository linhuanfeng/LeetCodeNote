package 剑指Offer59II.队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 均摊思想，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 说明一定要多开一个辅助双端队列，牺牲空间来换时间
 * 本算法的思想是：当前正常队列中小于最大值的元素对结果没有影响，所以只需要储较大值就行。
 *    双端队列队尾入队时，弹出队尾小于当前得元素得所有值，保证辅助队列时单调得
 *    另外注意当删除普通队列，判断双端队列对头是同一个，是则要出队
 */
public class MaxQueue {
    Queue<Integer> queue=null;
    Deque<Integer> deque=null;
    public MaxQueue() {
        queue=new LinkedList<>(); // 构建大根堆
        deque=new LinkedList<>();
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
        Integer poll = queue.poll();
        if(poll!=null&&deque.peekFirst()!=null){
            if(poll.compareTo(deque.peekFirst())==0){
                // 出队元素是双端队列的队头的话，那么双端队列也要出队
                deque.poll();
            }
            return poll;
        }
        return -1;
    }
}
