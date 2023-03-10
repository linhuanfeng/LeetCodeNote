package final关键字;

/**
 * final表示声明为常量或不可变
 *
 * 声明基本数据类型：常量。（声明的时候就得赋值，需要在代码块或构造方法中显示赋值）
 * 声明引用类型：引用地址不可变,地址内容可变
 * 声明方法：不能被重写
 * 声明类：不能被继承，不可变类。像String,Integer
 *
 * 注意final不能修饰abstract
 */
public abstract class Test {
    final int m = 100;
    final int n; // 成员变量final修饰,一堆得显示赋值

    public Test() {
        n = 10;
    }

    public Test(int n) {
        this.n = 10;
    }

    void f2() {
        final int n; // 局部变量final，编译不出错。
    }

    void f3() {
        final int n;
//        System.out.println(n); // 没赋值直接使用还是会报错
    }

//    final abstract void f4(); // 编译出错，final不能修饰abstract

    public static void main(String[] args) {
        final IntegerTest p = new IntegerTest();
//        p=new IntegerTest(); // 编译出错，final修饰的引用，引用的地址不可以改变，
        p.x = 2; // 但是地址对应的内容可以改变

        System.out.println(InterfaceTest.n); // 接口变量默认被public static final
    }
}
