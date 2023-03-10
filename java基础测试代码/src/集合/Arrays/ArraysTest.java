package 集合.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 扩容oldCap+(cldCap>>1)  及扩容1.5倍
 */
public class ArraysTest {
    public static void main(String[] args) {
        /**
         * Arrays.toArray(T[] a)
         *         public <T> T[] toArray(T[] a) {
         *             int size = size();
         *             if (a.length < size)
         *                 return Arrays.copyOf(this.a, size,
         *                                      (Class<? extends T[]>) a.getClass());
         *             System.arraycopy(this.a, 0, a, 0, size);
         *             if (a.length > size)
         *                 a[size] = null;
         *             return a;
         *         }
         * 传入的数组长度不够，则返回新建数组
         * 否则把数组拷贝到传入的数组，并传回数组
         */
        Arrays.asList("a"); // 新建一个a长度的数组，所以当然不可以扩容 返回的是Arrsys的内部对象，不是ArrayList
        Collections.singletonList("a"); // 返回只有一个元素的list

        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("123");
        System.out.println(list.toString());

        int[] arr={};
//        Arrays.copyOf()
//        Arrays.so
    }
}
