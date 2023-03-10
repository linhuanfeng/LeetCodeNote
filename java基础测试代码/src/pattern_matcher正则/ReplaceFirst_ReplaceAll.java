package pattern_matcher正则;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceFirst_ReplaceAll {
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " +
            "All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT); // The cat says meow. All cats say meow.
        INPUT = m.replaceFirst(REPLACE);
        System.out.println(INPUT); // The cat says meow. All dogs say meow.
    }
}
