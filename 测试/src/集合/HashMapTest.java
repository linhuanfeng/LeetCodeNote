package 集合;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        System.out.println(map.containsKey(1)); // true
        map.put(1280,1);
        System.out.println(map.containsKey(1280)); // true
        map.put(333,0);
        map.put(0,0);
        System.out.println("三种迭代器");
        iterat1(map);
        iterat2(map);
        iterat3(map);
    }

    // foreach模式
    private static void iterat1(Map<Integer, Integer> map) {
        map.forEach((key,val)-> System.out.print(key+":"+val+" "));
        System.out.println();
    }
    // iterator迭代器模式
    private static void iterat2(Map<Integer, Integer> map) {
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.print(next.getKey()+":"+next.getValue()+" ");
        }
        System.out.println();
    }
    // keyset values
    private static void iterat3(Map<Integer, Integer> map) {
        for (Integer integer : map.keySet()) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer value : map.values()) {
            System.out.print(value+" ");
        }
    }
}
