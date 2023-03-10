package 保留小数点2位.BigDecimal用法;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal精度实现原理：转为整数进行运算
 * 整数存储没有精度丢失问题，那么把小数先按精度*1000转为整数进行运算，用完再除以10000即可
 * BigDecimal顾名思义，就是大十进制的意思
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal(1.00);
        // 加 add
        System.out.println(decimal.add(BigDecimal.TEN)); // 11
        // 减 subtract
        System.out.println(decimal.subtract(BigDecimal.ONE)); // 0
        // 乘 multiply
        System.out.println(decimal.multiply(decimal)); // 1
        // 除  0.33 HALF_UP找到最接近的，相等则往大的取
        System.out.println(decimal.divide(BigDecimal.valueOf(3),2, RoundingMode.HALF_UP)); // 0.33
    }
}
