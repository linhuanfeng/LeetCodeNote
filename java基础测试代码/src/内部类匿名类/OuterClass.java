package 内部类匿名类;

public class OuterClass {
    private static int staticAge;
    private int age;

    public static class StaticInnerClass {
        public static void func() { // 静态内部类可以有static方法
            System.out.println(staticAge);// 静态内部类可以访问外部类静态成员
//            System.out.println(age); // 编译失败，静态内部类（静态成员）不能访问外部类非静态成员
        }
    }

    public class InnerClass {
//        static void staticFunc(){ // 非静态内部类不可以有static方法（因为static是类成员，内部类是实例成员）
//
//        }
    }
}
