package 构造方法与普通方法重名;

public class Test2 {
    public Test2() {
        System.out.println("无参");
    }

    //    public Test2(String name){
//        this();
//        System.out.println("有参1");
//    }
    public Test2(String name) {
        System.out.println("有参2");
    }

    public static void main(String[] args) {
        Test2 qwe = new Test2("qwe");
    }
}
