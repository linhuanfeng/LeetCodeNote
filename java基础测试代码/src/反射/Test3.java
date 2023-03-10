package 反射;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        Class<ArrayList> cls = ArrayList.class;
        Field field = cls.getDeclaredField("elementData");
        field.setAccessible(true);
        list.add(2);
        Object[] objs = (Object[]) field.get(list);
        System.out.println(objs.length); // 10
    }
}
