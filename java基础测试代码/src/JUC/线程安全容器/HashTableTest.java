package JUC.线程安全容器;

import java.util.Hashtable;

/**
 * 单纯也是在方法上加了synchronized关键字
 * public synchronized V get(Object key) {}
 */
public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
    }
}
