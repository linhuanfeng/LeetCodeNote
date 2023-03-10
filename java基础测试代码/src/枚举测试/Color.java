package 枚举测试;

/**
 * 枚举作用：以前定义常量：public static final int a=4;
 * 自动继承java.lang.Object.Enum
 */
public enum  Color {
    yellow("i am yellow"),Black("i am black");
    private String name;
    // 不用修饰符，默认就是私有
    // 枚举一旦定义完成，编译器不允许使用构造器创建其实例-->所以一定是单例的
    Color(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
