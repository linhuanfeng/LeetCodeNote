package static关键字;

public abstract class Father {
//    static int b=a; // 不能引用后面的，因为后面的还没加载
    static int a=0;

//    int b=c; // 不能引用后面的，因为后面的还没加载
    int c=0;
    static void f1(){

    }

    abstract void f2();

    public void f3(){
        a++;
        System.out.println("a:"+a);
    }
    public static void f4(){
//        int d=c; // 静态方法不能引用非静态资源
//        this.f5(); // 静态方法不能使用super或this
    }
    public static void f5(){}
}
