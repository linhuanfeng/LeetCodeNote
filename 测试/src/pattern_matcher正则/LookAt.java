package pattern_matcher正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。
 * 它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。
 *
 * lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
 */
public class LookAt {
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static final String INPUT2 = "ooooofoooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;
    private static Matcher matcher2;

    public static void main( String[] args ){
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
        System.out.println("Current INPUT2 is: "+INPUT2);


        System.out.println("lookingAt(): "+matcher.lookingAt()); // true
        System.out.println("matches(): "+matcher.matches()); // false
        System.out.println("lookingAt(): "+matcher2.lookingAt()); // false
    }
}
