package 集合.泛型SuperExtend;

import java.util.ArrayList;
import java.util.List;

class A{
}

class B extends A{
}

/**
 * List<? super A>： A和A的父类
 * List<? extends A>： A和A的子类对象
 */
public class Test{
    public static void method1(List<? super A> list){ // A和A的父类，不可以用A引用（下转型需要强制转换）
        for (int i = 0; i < list.size(); i++) {
//            A a=list.get(i); // 编译报错
        }
    }
    public static void method2(List<? extends A> list){ // A和A的子类对象，所以可以用引用A（上转型）
        for (int i = 0; i < list.size(); i++) {
            A a=list.get(i);
        }
    }
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        list.add(new B());
        method1(list);
        method2(list);
    }
}