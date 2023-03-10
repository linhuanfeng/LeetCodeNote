package JUC.unsafeCAS测试;

import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Que {

    private static final Unsafe unsafe; // 可直接操作内存
    private static final long tailOffset; // 字段在内存的偏移量，即指针
    private volatile Node head;
    private volatile Node tail;

    static {
        // 不是系统类加载器会报异常，那么我们使用反射.并且unsafe是单例的
//            tailOffset = unsafe.objectFieldOffset(Que.class.getDeclaredField("tail"));
        try {
//            Constructor<Unsafe> constructor = Unsafe.class.getConstructor(null); // private构造会报异常
            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Unsafe unsafe1 = constructor.newInstance(null);

            // theUnsafe保留着Unsafe的单例对象，也可以通过反射获取字段间接获取单例对象
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Unsafe unsafe2 = (Unsafe) field.get(null);

            unsafe=unsafe2;
            tailOffset=unsafe.objectFieldOffset(Que.class.getDeclaredField("tail"));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }

    public void offer(int val) {
        Node node = new Node(val);
        Node pred = tail; // 记录尾指针
        if (pred == null) {
            head = tail = node;
        } else {
            node.prev=pred;
            if(compareAndSetTail(pred, node)){ // 将tail指针指向node，注意pred还是指向原来的tail地址
                                               // 效果的等价于tail=node;
                pred.next=node;
            }
        }
    }

    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    class Node {
        Node prev;
        Node next;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
