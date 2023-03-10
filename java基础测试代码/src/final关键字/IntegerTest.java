package final关键字;

/**
 * 包装类像Integer,Long,Double,String,Character都是final修饰，都是不可变类
 */
// public final class Integer extends Number implements Comparable<Integer>
public class IntegerTest {
    int x;
    public static Integer y=10;
    static void updateY(Integer y){ // {Integer@482}
        y=y*30; // {Integer@483}
    }
    public static void main(String[] args) {
        updateY(y);
        // {Integer@482}
        System.out.println(y); // 10
    }
}
