package 字符串模式匹配;

import java.io.*;
import java.util.regex.*;
public class Main {
        public static void main(String[] args) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String p=br.readLine(),t=br.readLine();
                //if(p.charAt(i)=='?'){
                //   sb.append("[^' ']+");
            Pattern p2=Pattern.compile(p.replaceAll("\\?",".").replaceAll("\\*",".*"));
            Matcher m=p2.matcher(t);
            if(m.matches()){ // 整个匹配
                System.out.println("1");
            }else{
                System.out.println("0");
            }
        }
}