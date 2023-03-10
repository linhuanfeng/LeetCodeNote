package 反射;


import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SearchParam {

    /**
     * 关键字 比如小米
     */
    private String keyword;
    private String areaName;
    private String tag;
    private Integer from = 0;
    private Integer size = 10;

    public static void main(String[] args) throws ClassNotFoundException {
        Map<String, Object> map = new HashMap<>();
        map.put("keyword", "keyword");
        map.put("areaName", "keyword");
        map.put("tag", "keyword");
        map.put("from", "1");
        map.put("size", "10");
        SearchParam searchParam = MapToObj(map, SearchParam.class);
//        System.out.println(searchParam);
        SearchParam searchParam2 = MapToObjBySetter(map, SearchParam.class);
        System.out.println(searchParam2);
    }

    /**
     * Can not set java.lang.Integer field 反射.SearchParam.from to (int)1
     * @param map
     * @param clz
     * @return
     * @param <T>
     */
    public static <T> T MapToObj(Map<String, Object> map, Class<T> clz) {
        try {
            Object obj = clz.newInstance();
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                Object val = map.get(field.getName());
                if (val == null) {
                    continue;
                }
                field.setAccessible(true);
                Class<?> type = field.getType();
                if (type == Long.class || type == long.class) {
                    field.setLong(obj, Long.parseLong((String) val));
                } else if (type == Integer.class || type == int.class) {
                    field.setInt(obj, Integer.valueOf((String) val));
                } else if (type == Double.class || type == double.class) {
                    field.setDouble(obj, Double.parseDouble((String) val));
                } else {
                    field.set(obj, val);
                }
            }
            return (T) obj;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static  <T> T MapToObjBySetter(Map<String, Object> map, Class<T> clz) {
        try {
            Object obj = clz.newInstance();
            Field[] fields = clz.getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                Object val = map.get(name);
                if (val == null) {
                    continue;
                }
                // 拼接setter方法
                String setter="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                Method method = clz.getDeclaredMethod(setter, field.getType());

                Class<?> type = field.getType();
                if (type == Long.class || type == long.class) {
                    method.invoke(obj, Long.parseLong((String) val));
                } else if (type == Integer.class || type == int.class) {
                    method.invoke(obj,Integer.valueOf((String) val));
                } else if (type == Double.class || type == double.class) {
                    method.invoke(obj, Double.parseDouble((String) val));
                } else {
                    method.invoke(obj, val);
                }
            }
            return (T) obj;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "keyword='" + keyword + '\'' +
                ", areaName='" + areaName + '\'' +
                ", tag='" + tag + '\'' +
                ", from=" + from +
                ", size=" + size +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
