import java.util.HashMap;

public class Solution {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder builder=new StringBuilder();
        for (char aChar : chars) {
            builder.append(aChar==' '?"%20":aChar);
        }
        return builder.toString();
    }
}