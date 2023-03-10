package 内部类匿名类;

/**
 * 创建静态内部类对象不需要持有外部类的引用
 * 创建非静态内部类对象需要先持有外部类的引用，（因为非静态内部类是实例成员）
 *
 * 静态内部类可以访问外部类静态成员
 * 非静态内部类不可以有static方法（因为static是类成员，内部类是实例成员）
 */
public class Test {
    public static void main(String[] args) {
        // 创建静态内部类对象不需要持有外部类的引用
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        // 创建非静态内部类对象需要先持有外部类的引用，（因为非静态内部类是实例成员）
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();// 得先持有外部类的对象才能访问其实例成员
    }
}
