package 集合;

import java.util.Hashtable;

/**
 * Hashtable的方法都用synchronized修饰
 * key和value都不能为空
 *
 *
 *     public synchronized V put(K key, V value) {
 *         // Make sure the value is not null
 *         if (value == null) {
 *             throw new NullPointerException();
 *         }
 *
 *         // Makes sure the key is not already in the hashtable.
 *         Entry<?,?> tab[] = table;
 *         int hash = key.hashCode();
 */
public class HashtableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("","");
    }
}
