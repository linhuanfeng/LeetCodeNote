package 字符匹配;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution2 {
    /**
     * 在句子中找到前缀是str的首个单词位置
     * @param s string字符串 英文句子
     * @param x string字符串 字符串
     * @return int整型
     */
    public int match_str_in_sentence (String s, String x) {
        if(x.equals("")){
            return -1;
        }
        Pattern p2= Pattern.compile(" ");
        Matcher m2= p2.matcher(s);

        if(s.indexOf(x)>=0){
            int count=1;
            while(m2.find()){
                if(m2.start()<s.indexOf(x)){
                    count++;
                }else {
                    break;
                }
            }
            return count;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.match_str_in_sentence("this is an easy problem.", "eas"));
    }
}