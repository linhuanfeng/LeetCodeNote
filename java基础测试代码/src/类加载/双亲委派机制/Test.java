package 类加载.双亲委派机制;

/**
 * 保证类只加载一次，不同类加载器加载的类instanceof都是不相等的（即使是同个类）
 * 为了安全，Object核心不能让被人随意修改
 */
public class Test {
    public static void main(String[] args) {

    }
}
