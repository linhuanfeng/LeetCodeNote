package 多态成员访问;

/**
 * 多态成员访问特点：
 * 成员变量：编译和运行都是看左边
 * 构造方法：默认先调用父类的无参构造方法（如果父类没有无参构造方法，要显示指定父类有参构造方法）
 * 成员方法：编译看左边，运行看右边
 */
public class Test {
    public static void main(String[] args) {
        Father f = new Son(1);
        System.out.println(f.n);     // 10
        System.out.println(f.getN());// 20

        Son s= new Son(1);
        System.out.println(s.n);     // 20
        System.out.println(s.getN());// 20
    }
}
