package String不可变性.split测试;

public class Test {
    public static void main(String[] args) {
        String str="Alpha.Beat.Gamma.";
//        String regex="\\.\\s*";
        String regex="\\.";
        String[] split = str.split(regex);

        System.out.println("length:"+split.length); // 3
        for (String s : split) {
            System.out.println(s);
        }
    }
}
