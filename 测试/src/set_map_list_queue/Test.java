package set_map_list_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        // treeSet底层是用treeMap实现，treeMqp就是红黑树算法的实现
        TreeSet<Integer> set = new TreeSet<>();
//        set.add(null); // 不能存key为null,因为会调用key.compareTo() 报空指针异常
        Set<Integer> set2=new HashSet<>();
        set2.add(null); // hashSet则可以存一个，因为底层用的是
    }
}
