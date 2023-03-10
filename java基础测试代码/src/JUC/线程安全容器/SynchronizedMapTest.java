package JUC.线程安全容器;

import java.util.*;

/**
 *         SynchronizedMap(Map<K,V> m) {
 *             this.m = Objects.requireNonNull(m);
 *             mutex = this;
 *         }
 *         // 就单纯加了一个锁
 *         public V get(Object key) {
 *             synchronized (mutex) {return m.get(key);}
 *         }
 *
 *         public V put(K key, V value) {
 *             synchronized (mutex) {return m.put(key, value);}
 *         }
 */
public class SynchronizedMapTest {
    public static void main(String[] args) {
        Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
    }
}
