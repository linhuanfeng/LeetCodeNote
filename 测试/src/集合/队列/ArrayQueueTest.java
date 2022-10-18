package 集合.队列;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * PriorityQueue默认小根堆
 * 可以用new PriorityQueue<Integer>((x,y)->(y-x))重写compare方法
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue=new ArrayBlockingQueue<>(20);
        System.out.println(queue.isEmpty()); // true
        System.out.println(queue.size()); // 0
        System.out.println("====================");
        queue.offer(8);
        queue.offer(3);
        queue.offer(9);
        while (queue.size()!=0){
            System.out.print(queue.poll()+" ");  // 8 3 9
        }
        System.out.println();
        System.out.println(queue.offer(null)); // 会报空指针异常
    }
}
