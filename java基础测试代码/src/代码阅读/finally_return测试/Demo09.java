package 代码阅读.finally_return测试;

import java.util.HashMap;
import java.util.Map;
/*
finally

对于引用数据类型来说，finally中对返回值的修改会影响try中的返回变量的值
 */
public class Demo09 {
    public static void main(String[] args) {
        System.out.println(getMap().get("KEY").toString());
    }

    public static Map<String,String> getMap(){
        Map<String,String> map = new HashMap<>();
        map.put("KEY","INIT");
        try{
            map.put("KEY","try");
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("KEY","catch");
        }finally {
            map.put("KEY","finally");
            map = null;
        }
        return map;
    }
}

