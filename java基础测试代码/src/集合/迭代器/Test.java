package 集合.迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 增加for循环（本质使用的就是迭代器），使用remove的时候迭代器的modCount并没有修改，所以保并发修改异常
 *        final void checkForComodification() {
 *             if (modCount != expectedModCount)
 *                 throw new ConcurrentModificationException();
 *         }
 * 正确的做法是使用迭代器的进行删除
 */
public class Test {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("2");
//        for (String str : list) {
//            System.out.println(str);
//            list.remove(str); // ConcurrentModificationException
//        }
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()){
            String next = iter.next();
            System.out.println(next);
            iter.remove();
        }
    }
}
