package 父子类加载顺序;

public class Father{
    static Hello hello1=new Hello("father 静态成员变量");
    Hello hello2=new Hello("father 非静态成员变量");
    {
        System.out.println("father 非静态代码块");
    }
    static {
        System.out.println("father 静态代码块");
    }
    public Father(){
        System.out.println("father 无参构造方法");
    }
    public Father(String name){
        System.out.println("father 有参构造方法");
    }
}