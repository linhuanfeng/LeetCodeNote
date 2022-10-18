package 父子类加载顺序;

public class Son extends Father {
    static Hello hello1=new Hello("Son 静态成员变量");
    Hello hello2=new Hello("Son 非静态成员变量");
    {
        System.out.println("Son 非静态代码块");
    }
    static {
        System.out.println("Son 静态代码块");
    }
    public Son(){
        // super 构造方法第一行默认是super
        System.out.println("son 无参构造方法");
    }
    public Son(String name){// 默认先执行父类的无参构造进行初始化
        System.out.println("son 有参构造方法");
//        super(); // 编译失败，super()要在构造方法的第一行（因为父类加载优先于子类）
//        this(); // this同理
    }
}