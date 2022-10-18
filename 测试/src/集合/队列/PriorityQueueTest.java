package 集合.队列;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue默认小根堆
 * 可以用new PriorityQueue<Integer>((x,y)->(y-x))重写compare方法
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        System.out.println(queue.isEmpty()); // true
        System.out.println(queue.size()); // 0
        System.out.println("====================");
        queue.offer(8);
        queue.offer(3);
        queue.offer(9);
        while (queue.size()!=0){
            System.out.print(queue.poll()+" ");  // 3 8 9
        }
        System.out.println();
        Queue<Integer> queue2=new PriorityQueue<Integer>((x,y)->(y-x)); //这样就实现了大根堆
        System.out.println("====================");
        queue2.offer(8);
        queue2.offer(3);
        queue2.offer(9);
        while (queue2.size()!=0){
            System.out.print(queue2.poll()+" "); // 9 8 3
        }
        System.out.println("====================");
        System.out.println(queue.offer(null)); // 会报空指针异常
    }
}
