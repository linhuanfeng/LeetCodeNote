package 父子类加载顺序;
/*
father 静态成员变量
father 静态代码块
Son 静态成员变量
Son 静态代码块
father 非静态成员变量
father 非静态代码块
father 无参构造方法
Son 非静态成员变量
Son 非静态代码块
son 有参构造方法
 */
public class Test {
    public static void main(String[] args) {
//        Son son = new Son();
        Son son = new Son("dsada");
//        son.getClass()
    }
}
