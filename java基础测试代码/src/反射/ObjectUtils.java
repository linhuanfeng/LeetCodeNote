package 反射;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.text.Annotation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectUtils {


    /**
     * 将数组下标对应的值赋值给对象
     * @param clazz 对象
     * @param cols  赋值数组（顺序要与对象字段自上而下顺序一致且长度相等）
     * @param <T>
     * @return
     */
    public static <T> T initObject(Class<T> clazz, String[] cols) throws InstantiationException, IllegalAccessException, NoSuchFieldException, ParseException {
        Field[] fields = clazz.getDeclaredFields();
        T instance = clazz.newInstance();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getType() == String.class) {
                copyToField(instance, fields[i].getName()).set(instance, cols[i]);
            } else if (fields[i].getType() == Date.class) {
                if (!isEmpty(cols[i]) && isDate(cols[i])) {
                    copyToField(instance, fields[i].getName()).set(instance, getDate(cols[i]));
                } else {
                    copyToField(instance, fields[i].getName()).set(instance, null);
                }
            } else if (fields[i].getType() == Double.class) {
                if (!isEmpty(cols[i])) {
                    copyToField(instance, fields[i].getName()).set(instance, Double.parseDouble(cols[i]));
                } else {
                    copyToField(instance, fields[i].getName()).set(instance, null);
                }
            } else if (fields[i].getType() == Integer.class) {
                if (!isEmpty(cols[i])) {
                    copyToField(instance, fields[i].getName()).set(instance, Integer.parseInt(cols[i]));
                } else {
                    copyToField(instance, fields[i].getName()).set(instance, null);
                }
            } else if (fields[i].getType() == Long.class) {
                if (!isEmpty(cols[i])) {
                    copyToField(instance, fields[i].getName()).set(instance, Long.parseLong(cols[i]));
                } else {
                    copyToField(instance, fields[i].getName()).set(instance, null);
                }
            } else if (fields[i].getType() == Boolean.class) {
                if (!isEmpty(cols[i])) {
                    copyToField(instance, fields[i].getName()).set(instance, Boolean.parseBoolean(cols[i]));
                } else {
                    copyToField(instance, fields[i].getName()).set(instance, null);
                }
            }
        }
        return instance;
    }


/**
     * 比较两个对象字段是否完全一致，返回不一致的字段名集合
     * @param obj1
     * @param obj2
     * @return
     */
    public static List<String> compareDiffFields(Object obj1, Object obj2){
        List<String> fs1 = Arrays.stream(obj1.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        List<String> fs2 = Arrays.stream(obj2.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        List<String> fields = new ArrayList<>();
        if(fs1.size() > fs2.size()){
            for (String f1 : fs1)
                if(!fs2.contains(f1))
                    fields.add(f1);
            return fields.size() > 0 ? fields : Collections.emptyList();
        } else {
            for (String f2 : fs2)
                if(!fs1.contains(f2))
                    fields.add(f2);
            return fields.size() > 0 ? fields : Collections.emptyList();
        }
    }


    /**
     * 比较两个对象的字段是否完全一致
     * @param obj1
     * @param obj2
     * @return
     */
    public static Boolean isFieldsEquals(Object obj1, Object obj2){
        List<String> fs1 = Arrays.stream(obj1.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        List<String> fs2 = Arrays.stream(obj2.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        if(fs1.size() == fs2.size()){
            for (String f1 : fs1)
                if(!fs2.contains(f1))
                    return false;
            return true;
        }
        return false;
    }


    /**
     * 获取对象的字段与类型键值对
     *
     * @param clazz
     * @return
     */
    public static Map<String, Class<?>> withFieldsAndTypes(Class<?> clazz) {
        Map<String, Class<?>> kv = new Hashtable<>();
        for (Field field : clazz.getDeclaredFields()) {
            kv.put(field.getName(), field.getType());
        }
        return kv;
    }


    /**
     * 得到对象内指定除外的的字段
     *
     * @param clazz    对象
     * @param excludes 定义除外的字段
     * @return
     */
    public static List<String> filterFields(Class<?> clazz, String... excludes) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null) {

            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }

        Field[] fields = fieldList.stream().toArray(Field[]::new);
        List<String> result = new ArrayList<>();

        for (Field field : fields) {
            result.add(field.getName());
        }

        for (String fieldName : excludes) {
            result.remove(fieldName);
        }

        return result;
    }


    /**
     * 得到类带指定注解的字段
     * @param clazz 对象
     * @param annotatedClass 注解
     * @return
     */
    public static List<String> getAnnotationFields(Class<?> clazz, Class<? extends Annotation> annotatedClass){
        List<String> fields = new ArrayList<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields.length != 0)
        {
            for (Field field : declaredFields)
            {
//                if (field.getAnnotation(annotatedClass) != null)
                {
                    fields.add(field.getName());
                }
            }
            return fields;
        }
        return null;
    }

    /**
     * Object转化List
     * @param obj 对象
     * @param clazz 转化的列表类型
     * @param <T> 列表类型
     * @return
     */
    public static <T> List<T> castList(Object obj, Class<T> clazz)
    {
        List<T> result = new ArrayList<T>();
        if(obj instanceof List<?>)
        {
            for (Object o : (List<?>) obj)
            {
                result.add(clazz.cast(o));
            }
            return result;
        }
        return null;
    }

    /**
     * 将多个相同的对象添加到列表当中
     * @param merged 多个对象
     * @param <T> 对象类型
     * @return
     */
    @SafeVarargs
    public static <T> List<T> asMergedList(T ...merged){

        return new ArrayList<T>(Arrays.asList(merged));
    }


    /**
     * 返回字段交换的对象
     * @param target 目标交换对象
     * @param result 交换结果对象
     * @param <T> 对象类型
     * @return
     */
    public static <T> T tempObject(Object target, T result){
        BeanUtils.copyProperties(target, result);
        return result;
    }


    /**
     * 将值拷贝到新实例的对象中
     * @param instance 新实例的对象
     * @param fieldName 当前字段名
     * @return
     */
    private static Field copyToField(Object instance, String fieldName) throws NoSuchFieldException {
        Field f = instance.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f;
    }

    private static Date getDate(String dateStr) throws ParseException {
        if (dateStr.length() > 23) {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US);
            return sdf.parse(dateStr);
        } else {
            return dateStr.length() > 8 && dateStr.contains(":") ? getFullDate(dateStr) : getSimpleDate(dateStr);
        }
    }


    private static Date getFullDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(dateStr.contains("T") ? "yyyy-MM-dd'T'HH:mm:ss" : "yyyy-MM-dd HH:mm:ss");
            return sdf.parse(dateStr);
        } catch (ParseException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static Date getSimpleDate(String dateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException var2) {
            var2.printStackTrace();
            return null;
        }
    }

    private static Boolean isDate(String str) {
//        try {
////            DateUtils.parseDate(str, "yyyy-MM-dd HH:mm:ss");
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
        return null;
    }

    private static boolean isEmpty(String str) {
        return null != str && str.length() > 0;
    }
}
