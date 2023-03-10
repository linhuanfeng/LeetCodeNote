package 集合.HashSet;


import java.util.HashSet;
import java.util.Set;

/**
 * 底层通过HashMap来实现去重，而HashMap当hash值相同时，会判断是否同个对象（==）或equals相同，会进行覆盖
 */
public class Test2 {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("AA");
        set.add("BB");
        set.add(new String("AA"));
        System.out.println(set.toString()); // [AA,BB]
    }
}
