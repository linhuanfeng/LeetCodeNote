package 类._this;

/**
 * 重点关注这段代码
 *
 * return Class.this等价于return this
 *
 *
 * 反编译代码
 * Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: areturn
 * LocalVariableTable:
 *         Start  Length  Slot  Name   Signature
 *             0       2     0  this   Lcom/bigdata/java/Demo62;
 * "aload_0"，表示将加载局部变量表slot0中的元素到操作数栈顶，而这个slot0中存储的就是this。
 * 这里先说明一下，每个方法（非静态方法）都隐含有一个“this”参数，这也是为什么我们能够在方法中使用this的原因。
 *
 * “areturn”，表示从方法返回引用。这里它将弹出操作数栈弹出的元素并返回。
 *
 * 小结：“类.this”得到的是当前类的实例。底层实际上就是得到方法的隐含参数this。
 */
public class Test {

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = test1.f1();
        Test test3 = test1.f2();
        System.out.println(test1==test2); // true
        System.out.println(test1==test3); // true
    }
    Test f1(){
        Test test = Test.this;
        return test;
    }

    Test f2(){
        return this;
    }
}
