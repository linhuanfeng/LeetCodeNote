package instanceof测试;
/*
继承树一样就返回true
 */
public class Test {
    public static void main(String[] args) {
//        Son son=new Son();
        Father son=new Son();
        System.out.println(son instanceof Son); // true
        System.out.println(son instanceof Father); // true
        System.out.println(son instanceof People); // true
        System.out.println(son instanceof Object); // true
    }
}
