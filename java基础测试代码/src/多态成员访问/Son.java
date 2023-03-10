package 多态成员访问;

public class Son extends Father {
    public int n=20;

//    public Son() {
//        System.out.println("son 无参构造方法");
//    }

    public Son(int n) {
        super(n); // 当父类没有无参构造方法的时候，要显示指定出来
        System.out.println("son 带参构造方法");
    }

    public int getN() {
        return n;
    }
}
