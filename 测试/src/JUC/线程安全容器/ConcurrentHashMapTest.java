package JUC.线程安全容器;

import java.util.concurrent.ConcurrentHashMap;

/**
 * hashTable 采用synchronized修饰
 * jdk1.7 segment extend reentrantLock,分段锁,采用
 * jdk1.8 cas+synchronized对当前对象加锁
 *  如果当前桶位为null则自选cas(null,new Node)获取锁，
 *  如果为空，则加synchronized（curNode）进行添加元素
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    }
}
