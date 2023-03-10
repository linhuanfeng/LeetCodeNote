package 父子类加载顺序.父子相同属性;

/**
 * 1.成员变量（属性）
 *    公开的和默认的属性，子类可以继承使用的
 *    私有的成员变量，子类无法使用的
 * 2.成员方法
 *    公开的和默认的成员方法，子类可以继承使用
 *    私有的成员方法，子类无法使用的
 * 总结：凡是私有的 无法继承。子类不能使用父类私有化的所有的东西。
 * 3.构造方法
 *    先执行父类的构造，再执行子类的构造方法
 *    如果父类中有有参构造，但是没有无参构造。子类会报错
 *    关于构造方法：父类与子类的构造方法的形式保持一致。父类中有无参构造。子类也有无参构造。
 *    父类中没有无参构造，子类也没有无参构造方法。
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Son().getName()); // father
    }
    static class Father{
        private String name="father";

        public String getName() {
            return name;
        }
    }
    static class Son extends Father{
        private String name="son";
    }
}
