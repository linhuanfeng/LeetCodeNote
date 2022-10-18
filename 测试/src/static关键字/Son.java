package static关键字;

/**
 * 子类不能重写父类static修饰的方法，因为static修饰的方法是类成员，类加载就确定了
 */
public class Son extends Father {
    @Override
    void f2() {

    }
//    @Override
//    static void f1(){} // 编译出错。子类不能重写父类static修饰的方法。（因为static修饰的方法是类成员，类加载就确定了）
}
