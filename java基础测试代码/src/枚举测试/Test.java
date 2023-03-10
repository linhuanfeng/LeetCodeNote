package 枚举测试;

public class Test {
    public static void main(String[] args) {
        System.out.println(Color.Black); //Black
        System.out.println(Color.Black== Color.Black); // true 枚举默认是单例的 一旦定义完成，不允许再使用构造器创建对象
        System.out.println(Color.Black.getName()); // i am black
    }
}
