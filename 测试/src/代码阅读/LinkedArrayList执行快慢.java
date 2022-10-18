package 代码阅读;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList需要移动元素，慢很多
 */
public class LinkedArrayList执行快慢 {
    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        List<Object> linkedList = new LinkedList<>();
        Object obj = new Object();

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            arrayList.add(0, obj);
        }
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            linkedList.add(0, obj);
        }
        long t4 = System.currentTimeMillis();

        System.out.println((t2-t1)+","+(t4-t3)); // 211 2
    }
}
