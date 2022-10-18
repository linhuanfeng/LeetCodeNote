package 不同的公共子串;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.nextLine(),s2=sc.nextLine();

        Set<String> set1=new HashSet<>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = i+1; j <= s1.length(); j++) {
                set1.add(s1.substring(i,j));
            }
        }
        long res=0;
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i+1; j <= s2.length(); j++) {
                String s = s2.substring(i, j);
                if(set1.contains(s)){
                    res++;
                    set1.remove(s);
                }
            }
        }
        System.out.println(res);
    }
}
