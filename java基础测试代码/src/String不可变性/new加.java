package String不可变性;

public class new加 {
    public static void main(String[] args) throws RuntimeException{
        String s1 = "ab";
        String s2 = new String("b");
        String s3 = "a";
        String s4 = "b";
        String s5 = "a" + "b";
        String s6 = s3 + s4;
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s5); // true
        System.out.println(s1 == s6); // false
    }
}
