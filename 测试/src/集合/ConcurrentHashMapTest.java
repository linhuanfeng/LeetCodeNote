package 集合;

import java.util.concurrent.ConcurrentHashMap;

/**
 * key和value都不能为null
 *
 * put：为null直接cas
 * 否则synchronized(Node f)+cas
 *
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
    }
}
