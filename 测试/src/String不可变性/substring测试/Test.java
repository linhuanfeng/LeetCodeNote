package String不可变性.substring测试;

public class Test {
    public static void main(String[] args) {
        String str="123";
        System.out.println(str.substring(3)); // ""
        System.out.println(str.substring(2)); // "3"
        System.out.println(str.substring(2,3)); // "3"
        System.out.println(str.substring(4)); // StringIndexOutOfBoundsException

    }
}
