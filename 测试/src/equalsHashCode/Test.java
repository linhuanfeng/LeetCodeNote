package equalsHashCode;

import java.util.HashMap;
import java.util.Map;

/**
 * String类重写了equals，比较其内容是否是否相等
 * 先==比较是否是同一个对象，再比较具体内容是否相等
 *
 * 为什么重写equals方法一定要重写hashCode方法？
 *      因为要保证equals方法相同的两个对象，其hashCode也要相同。如果不重写，比较是地址，对于两个不同对象的即使equals方法相同，hashCode也会不相同
 *    hashCode方法不仅和equals配套使用，还和整个集合配套使用，比如hashMap,hashSet
 */
public class Test {
    public static void main(String[] args) {
        String str1="1231";
        String str2="1231";
        String str3=new String("1231");
        System.out.println(str1.equals(str2)); // true
        System.out.println(str1.equals(str3)); // true

        Object obj = new Object();
        obj.equals(new Object()); // object默认是比较对象是否相等

//        Integer

//        HashMap
        /**
         * integer的hashCode就是返回对应的int值，equals比较的也是int值
         */
        // 下面这种肯定是不同对象，因为同个new出来
//        Integer integer1 = new Integer(1);
//        Integer integer2 = new Integer(1);
//        Integer integer3 = new Integer(1000);
//        Integer integer4 = new Integer(1000);
//        System.out.println("integer1==integer2:"+(integer1==integer2)); // integer3==integer4:false 肯定不同对象
//        System.out.println("integer3==integer4:"+(integer3==integer4)); // integer3==integer4:false 肯定不同对象
        Integer integer1 = Integer.valueOf(1);
        Integer integer2 = Integer.valueOf(1);
        Integer integer3 = Integer.valueOf(1000);
        Integer integer4 = Integer.valueOf(1000);
        System.out.println("integer1==integer2:"+(integer1==integer2)); // integer3==integer4:true [-128,127]走缓存
        System.out.println("integer3==integer4:"+(integer3==integer4)); // integer3==integer4:false 肯定不同对象
        System.out.println(integer1.hashCode()+" "+integer3.hashCode()); // 1 1000 就等于intValue

        Map<Integer,String> map=new HashMap<>();
        map.put(integer3,"interger3");
        map.put(integer3,"interger4"); // 覆盖了前一个的值，因为hashCode和equals都是相等
        System.out.println(map.get(integer3)); // interger4
        System.out.println(map.get(integer4)); // interger4

        String str="";
//        str.concat()
    }
}
