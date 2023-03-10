package 集合.list;

import java.util.ArrayList;
import java.util.List;

// 无参构造的时候，初始为空数组DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {}
// 第一次add添加元素后，会扩容为10，扩容大小为原始的1.5倍，数次扩容时由于小于默认的10，所以取10，之后每次扩容都是0.5
/*
    删除最大是size-1
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    增加最大size
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        System.out.println(list.remove(0));
        System.out.println("======================");
        list.add(0,1);
    }
}
