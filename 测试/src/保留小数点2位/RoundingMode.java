package 保留小数点2位;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 找到最接近的数，如果相等
 * HALF_DOWN           5舍去  1.5->1    1.6->2     -1.6->-2
 * HALF_UP（四舍五入）  5入    1.5->2    1.6->2     -1.6->-2
 *
 * CEILING:趋向正无穷  1.5->2   -1.5->-1
 * FLOOR:趋向负无穷  1.5->1   -1.5->-2
 *
 * 绝对值远离或趋近0
 * UP:远离0   1.5->2   -1.5->-2
 * DOWN:趋近0   1.5->1   -1.5->-1
 */
public class RoundingMode {
    public static void main(String[] args) {
        double d=-123123.125;
        // DecimalFormat
        NumberFormat instance = DecimalFormat.getInstance();
        instance.setMaximumFractionDigits(2);
        System.out.println(instance.format(d)); // -123123.12

        // String.format("%.2f")
        System.out.println(String.format("%.2f", d)); // -123123.13 四舍五入

        // BigDecimal
        BigDecimal bigDecimal = new BigDecimal(d).setScale(2, java.math.RoundingMode.HALF_UP); // -123123.13 四舍五入
        System.out.println(bigDecimal);


        Double d2 = new Double(1.2);
        System.out.println(d2.intValue());
    }
}
