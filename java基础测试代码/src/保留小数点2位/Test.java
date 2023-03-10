package 保留小数点2位;

import javax.swing.text.NumberFormatter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Formatter;

public class Test {
    public static void main(String[] args) {
        // String.format
        System.out.println(String.format("%.2f", 2.23423));
        // new Formatter().format
        System.out.println(new Formatter().format("%.2f", 2.23423));
        // DecimalFormat
        NumberFormat numberFormat = DecimalFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        System.out.println(numberFormat.format(2.23423));
        // new BigDecimal("2.23423")
        System.out.println(new BigDecimal("2.23423").setScale(2, RoundingMode.DOWN));
        /**
         *
         * RoundingMode.DOWN 不进位
         */

    }
}
