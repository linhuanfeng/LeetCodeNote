package 行为型模式.策略模式;

/**
 * 策略模式：
 * 传入不同的策略，可随意切换算法
 *          环境角色组合策略
 * 三种角色：
 *      1.context环境角色
 *      2.抽象策略
 *      3.具体策略
 *
 * 优点：
 *      1.提供了管理相同算法族的方法，恰好把相同的代码移到父类
 *      2.同个引用的方式让算法使用者和算法本身解耦
 *      3.避免多重条件转换语句
 */
public class Test {
    public static void main(String[] args) {
        Context ctx=new Context(new ConcreteStrategy());
        ctx.doInterface();
    }
}
