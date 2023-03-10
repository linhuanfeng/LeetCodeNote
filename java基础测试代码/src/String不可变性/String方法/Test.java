package String不可变性.String方法;

public class Test {
    public static void main(String[] args) {
        String s1="s1",s2="s2";
        System.out.println(s1+s2);
        System.out.println(s1.concat(s2));
//        System.out.println(s1.append(s2)); // String没有这个方法
        System.out.println(new StringBuilder(s1).append(s2));
    }
}
