package 内部类匿名类;

/**
 * 匿名内部类：好处：不用定义和创建实现类（子类）
 * 匿名内部类简写成lambda表达式
 */
public class Test2 {
    public static void main(String[] args) {
        // 匿名内部类：好处：不用定义和创建实现类（子类）
        new AnoyniousClaz(){
            @Override
            public void eat() {
                System.out.println("eat");
            }
        }.eat();
        // 匿名内部类简写成lambda表达式
        ((AnoyniousClaz) () -> System.out.println("eat")).eat();
    }
}
