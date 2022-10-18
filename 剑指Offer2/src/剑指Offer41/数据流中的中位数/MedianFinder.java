package 剑指Offer41.数据流中的中位数;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * priority就是大小堆实现
 * 维护两个堆，因为要取中位数，所以小堆存放较大的数，大堆存放较小的数，保持两堆大小相等或者A比B大1
 * 时间复杂度：每次就是维护堆所花费的时间O(logn)
 * 空间复杂度：两个堆存放所有的元素：O（n）
 */
public class MedianFinder {
    Queue<Integer> A;
    Queue<Integer> B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A=new PriorityQueue<>((x,y)->(y-x)); // 大根堆
        B=new PriorityQueue<>(); // 默认小根堆
    }

    public void addNum(int num) {
        // 较小的数放大堆
//        if(sHeap.size()==0){}A
        if(B.size()!=0&&num>=B.peek()){
            // 说明是较大的原色，则放进小队
            B.offer(num);
        }else {
            // 堆B为空或num值B的堆顶小
            A.offer(num);
        }
        // 平衡两个堆的数量
        int a=A.size();
        int b=B.size();
        if(a-b>1){
            B.offer(A.poll());
        }else if(b>a){
            A.offer(B.poll());
        }
    }

    public double findMedian() {
        if(A.size()==B.size()){
            return (A.peek()+B.peek())/2.0;
        }else {
            return A.peek();
        }
    }
}
