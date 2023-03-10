package 百度_代码算for循环的次数_堆;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * import java.util.*;
 * <p>
 * public class Main{
 * public static void main(String[] args){
 * Scanner in = new Scanner(System.in);
 * int a = 0 , b = 0;
 * int n = in.nextInt();
 * for (int i = 0; i < n; i++) {
 * if ( a < b ) {
 * a += b / 2;
 * }
 * for (int j = 0; j < n; j++) {
 * b++;
 * a += b;
 * }
 * for (int j = 1; j < n; j *= 2) {
 * b--;
 * }
 * }
 * System.out.println(a);
 * }
 * }
 * <p>
 * 2
 */
// 通过一个，其它用例不知道
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        Pattern pF = Pattern.compile("for");
        Pattern pM = Pattern.compile(".*Main.*");

        while (true) {
            String line = br.readLine();
            if (pM.matcher(line).matches()) {
                break;
            }
        }

        Deque<Character> que_L = new LinkedList<>();
        Deque<String> que_All = new LinkedList<>();
        que_L.addLast('{');

        while (true) { // main开始
            String line = br.readLine();

            Matcher matcher2 = pF.matcher(line);
            while (matcher2.find()) {
                que_All.addLast("for");
            }

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '{') {
                    que_All.addLast("{");
                    que_L.addLast('{');
                } else if (line.charAt(i) == '}') {
                    que_L.removeLast();
                    que_All.addLast("}");
                }
            }
            if (que_L.isEmpty()) {
                break;
            }
            list.add(line);
        }

        while (que_All.getFirst().equals("{")){
            que_All.removeFirst();
            que_All.removeLast();
        }

        Deque<String> list1=new LinkedList<>();
        for (String s : que_All) {
            if(s.equals("for")){
                if(list1.isEmpty()||(!list1.getLast().equals("for"))){
                    list1.addLast("for");
                }
            }
            else if(s.equals("}")){
                if(list1.getLast().equals("for")){
                    bw.write(list1.size()-1+" ");
                    bw.flush();
                    return;
                }
                list1.removeLast();
            }else {
                list1.addLast("{");
            }
        }
    }
}
