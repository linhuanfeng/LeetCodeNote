package 集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Object> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        map.put("a",list);
        System.out.println(map);
        System.out.println(list);
    }
}
