package 集合.流操作;

import java.util.ArrayList;

/**
 * list.forEach集合流操作
 */
public class Test4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.forEach(e-> System.out.println(e)); // 集合流操作
    }
}
