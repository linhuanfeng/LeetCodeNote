package 抽象类和接口;

/**
 * 抽象类或方法的不能被final或static修饰
 */
public abstract class AbsC {
    int i = 0; // 普通类成员，没有static修饰等
    int j;
//  j=1; // 只能有变量和方法，不能有其他语句
    abstract void func();
}
