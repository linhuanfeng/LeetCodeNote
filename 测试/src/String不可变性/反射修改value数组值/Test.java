package String不可变性.反射修改value数组值;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        String str="aaa";
        System.out.println(str); // 1aa
        //  反射修改value数组，打破不可变性
        Class<?> forName = Class.forName("java.lang.String");
        Field field = forName.getDeclaredField("value");
        field.setAccessible(true);
        char[] value=(char[])field.get(str);
        value[0]='1';

        System.out.println(str); // 1aa
    }
}
