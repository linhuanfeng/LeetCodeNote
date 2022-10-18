package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU extends LinkedHashMap<String,String> {
    int cacheSize=0;
    public LRU(int cacheSize) {
        // accessOrder表示将访问的元素移到队尾
        super((int) Math.ceil(cacheSize/0.75)+1, 0.75f, true);
        this.cacheSize=cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
        return size()>cacheSize;
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put("1","1");
        lru.put("2","1");
        lru.put("3","1");
        lru.put("4","1");
        System.out.println("是否包含最老的1:"+lru.containsKey("1")+",size="+lru.size());
        for (Map.Entry<String, String> entry : lru.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        } // 2,3,4
        lru.get("3");
        System.out.println("=====新访问的元素会移到队尾======");
        for (Map.Entry<String, String> entry : lru.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        } // 2,4,3
    }
}
