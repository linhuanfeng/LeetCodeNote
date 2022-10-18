package pattern_matcher正则;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class start_end {
    public static void main(String[] args) {
        final String REGEX = "%([^%]*)+%";
        final String INPUT = "%%abc%sada%%";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0,last=0;

        StringBuffer sb=new StringBuffer();

        while (m.find()) { // 寻找一个个匹配，找不到返回false
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
            int start = m.start();
            int end = m.end();
//            sb.append(INPUT, last, start);
            m.appendReplacement(sb,"?");
        }
        m.appendTail(sb);
        System.out.println(sb);
    }
    @Test
    public void test1(){
        String REGEX = "\\bcat\\b"; // 匹配单词得边界
        String INPUT = "cat cat cat cattie cat";
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;
        while (m.find()) { // 尝试查找下一个匹配得序列
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start()); // 0
            System.out.println("end(): " + m.end()); // 3(有边界不包括)
        }
        System.out.println(m.matches()); // false,尝试与整个进行匹配
        /*
        Match number 1
        start(): 0
        end(): 3
        Match number 2
        start(): 4
        end(): 7
        Match number 3
        start(): 8
        end(): 11
        Match number 4
        start(): 19
        end(): 22
         */
    }
}