package pattern_matcher正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches:整个区域完全匹配，而不是局部匹配
 * find:尝试查找下一个匹配的局部区域
 */
public class Matches {
    public static void main(String[] args) {
        String regex="\\bcat\\b";
        Pattern p = Pattern.compile(regex);
        System.out.println("========"+regex+"========");

        String input="cat cat cat cattie cat";
        Matcher m = p.matcher(input);
        System.out.println("======="+input+"=======");
        System.out.println("matches:" + m.matches()); // false
        System.out.println("find:"+m.find()); // true

        input="1cat1";
        Matcher m2 = p.matcher(input);
        System.out.println("======="+input+"=======");
        System.out.println("matches:" + m2.matches()); // false
        System.out.println("find:"+m2.find()); // false

        input="cat";
        Matcher m3 = p.matcher(input);
        System.out.println("======="+input+"=======");
        System.out.println("matches:" + m3.matches()); // true
        System.out.println("find:"+m3.find()); // false

        input="cat cat";
        Matcher m4 = p.matcher(input);
        System.out.println("======="+input+"=======");
        System.out.println("matches:" + m4.matches()); // false
        System.out.println("find:"+m4.find()); // true
    }
}
