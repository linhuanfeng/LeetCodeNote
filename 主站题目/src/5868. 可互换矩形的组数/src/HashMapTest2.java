import java.util.HashMap;

public class HashMapTest2 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(new String("adc"),1);
        String  s1=new String("abc");
        String s2="abc";
        // new Str:false||||='abc':false 存的是对象的引用
        System.out.println("new Str:"+hashMap.containsKey(s1)+"||||='abc':"+hashMap.containsKey(s2));
        HashMap<Long, Integer> hashMap2 = new HashMap<>();
        hashMap2.put(new Long(2),1);
        hashMap2.put(new Long(123456789),1);
        Long  l1=new Long(2);
        Long  l2=new Long(123456789);
        // new Long2:true###new Long123456789:true
        System.out.println("new Long2:"+hashMap2.containsKey(l1)+"###new Long123456789:"+hashMap2.containsKey(l2));

    }
}
