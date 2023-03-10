package 构造方法与普通方法重名;

/**
 * 普通与构造方法同名只会警告不好报错
 *
 * 2.方法名前面没有返回值，甚至连表示没有返回值的空类型(void)也没有。
 * 一定要有，不然会自动生成一个无参的
 */
public class Test {
    public Test(){
        System.out.println("我是构造方法");
    }
    // 普通方法
    public void Test(){
        System.out.println("我是普通方法");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.Test();
    }
}
