package a146.LRU缓存;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class Test {

    @org.junit.Test
    public void testLRU(){
        LRUCache cache = new LRUCache(2);
        cache.put(1,2);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        HashMap<String, String> map = new HashMap<>();
        map.get("");
    }
}
