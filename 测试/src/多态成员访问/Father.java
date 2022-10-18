package 多态成员访问;

public class Father {
    public int n=10;

//    public Father() {
//        System.out.println("father 无参构造方法");
//    }

    public Father(int n) {
        System.out.println("father 带参构造方法");
    }

    public int getN() {
        return n;
    }
}
