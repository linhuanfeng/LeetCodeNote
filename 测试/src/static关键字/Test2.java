package static关键字;

 class MyClass {
    private static MyClass myClass=new MyClass(); // 1
    public static  int a; // 4
    public static  int b=0; // 5

    public MyClass() {
        a=5; // 2
        b=5; // 3
    }
    public static MyClass getInstance(){
        return myClass;
    }
}
public class Test2 {
    public static void main(String[] args) {
        MyClass myClass = MyClass.getInstance();
        System.out.println(myClass.a); // 5
        System.out.println(myClass.b); // 0 `b=0`晚于构造中执行,所以被重新赋值给0
    }
}