package equals和等于;

import net.minidev.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

public class ClassEqualsTest {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        System.out.println(list1.getClass()); // class java.util.ArrayList
        System.out.println(list1.getClass().equals(list2.getClass())); // true 因为Class是同一个
    }
}
