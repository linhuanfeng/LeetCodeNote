package pattern_matcher正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通配符`*`号，匹配前面的子表达式零次或多次，等价于{0,}。
 */
public class Test2 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("zo*");
        Matcher m = p.matcher("z");
        Matcher m2 = p.matcher("zo");
        Matcher m3 = p.matcher("zoo");

        System.out.println(m.matches()); // true
        System.out.println(m2.matches()); // true
        System.out.println(m3.matches()); // true
    }
}
