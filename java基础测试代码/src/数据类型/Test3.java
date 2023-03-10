package 数据类型;

/**
 * 浮点数不是精确计算，应使用BigDecimal
 * ==不能比较boolean和int类型
 */
public class Test3 {
    public static void main(String[] args) {
        int i1=1;
        float f1=1;
        double d1=1;
        System.out.println(i1==f1); // true
        System.out.println(i1==d1); // true
        System.out.println(f1==d1); // true
        System.out.println("============");

        float f2=0.3f;
        double d2=0.3;
        System.out.println(f2==d2); // false 因为不是精确运算

        byte b=1;
        boolean b1=true,b2=true;
//        System.out.println(b1==1); // 编译出错，==不能比较boolean和int类型
    }
}
