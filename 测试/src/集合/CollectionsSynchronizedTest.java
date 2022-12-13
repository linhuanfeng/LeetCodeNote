package 集合;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * synchronizedList
 * synchronizedMap
 * synchronizedSet
 *
 * 操作委托给原对象，然后包裹synchronized(object)互斥锁进行访问
 *
 *      private static class SynchronizedMap<K,V>
 *         implements Map<K,V>, Serializable {
 *         private static final long serialVersionUID = 1978198479659022715L;
 *
 *         private final Map<K,V> m;     // Backing Map
 *         final Object      mutex;        // Object on which to synchronize
 *
 *         SynchronizedMap(Map<K,V> m) {
 *             this.m = Objects.requireNonNull(m);
 *             mutex = this;
 *         }
 *             public int size() {
 *             synchronized (mutex) {return m.size();}
 *         }
 *         public boolean isEmpty() {
 *             synchronized (mutex) {return m.isEmpty();}
 *         }
 *         public boolean containsKey(Object key) {
 *             synchronized (mutex) {return m.containsKey(key);}
 *         }
 *         public boolean containsValue(Object value) {
 *             synchronized (mutex) {return m.containsValue(value);}
 *         }
 *         public V get(Object key) {
 *             synchronized (mutex) {return m.get(key);}
 *         }
 */
public class CollectionsSynchronizedTest {
    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<>());
        Collections.synchronizedMap(new HashMap<>());
        Collections.synchronizedSet(new HashSet<>());
    }
}
