package 字符查找;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        Pattern p = Pattern.compile("zura");
        Matcher m = p.matcher(str);
        int cnt=0;
        while (m.find()){
            cnt++;
        }
        System.out.println(cnt);
    }
}
