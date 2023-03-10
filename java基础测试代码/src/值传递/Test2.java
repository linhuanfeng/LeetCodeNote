package 值传递;

/**
 * public final class Integer extends Number implements Comparable<Integer> {
 * 包装类的不可变性
 */
public class Test2 {
    public static void main(String[] args) {
        Integer integer = new Integer(2);
        Integer ref=integer;
        System.out.println("形参："+integer+"="+(integer==ref)); // 形参：2=true
        new Test2().update(integer);
        System.out.println("形参："+integer+"=："+(integer==ref)); // 形参：2=：true
    }
    void update(Integer x){ // 值传递，复杂数据类型即使地址值的传递，也是值传递，地址指向的地方是相同的，
        Integer ref=x;
        System.out.println("实参："+x+"="+(x==ref)); // 实参：2=true
        x=x*2;      // 但由于包装类的不可变性，所以x相当于指向了新new的地址了
        System.out.println("实参："+x+"="+(x==ref)); // 实参：4=false
    }
}
