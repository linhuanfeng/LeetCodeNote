package JUC.线程安全容器;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Test {
    public static void main(String[] args) {
        // JUC
        new ConcurrentHashMap<String,String >();
        new CopyOnWriteArraySet<String>();
        new CopyOnWriteArrayList<String>();

        // util工具类
        new Hashtable<String,String>();
        new Vector<String>(); // 近似synchronized修饰的ArrayList

        Collections.synchronizedCollection(new ArrayList<>());
        Collections.synchronizedList(new LinkedList<>());
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedSet(new HashSet<>());
    }
}
