package DNA序列;

import java.io.*;
import java.util.PriorityQueue;

/**
 * 5 4
 * 1 2 3 4 5
 * 3 5 7 9 11
 *
 * 竟然ac了
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int k=Integer.valueOf(br.readLine());

        int count=0,max=0;
        String ans="";
        StringBuilder sb=new StringBuilder();
        int i;
        for (i = 0; i < k; i++) {
            char c = str.charAt(i);
            sb.append(c);
            if(check(c)){
                count++;
            }
        }
        max=count;
        ans=sb.toString();
        i++;
        int left=0;
        for (int j = k; j < str.length(); j++) {
            sb.deleteCharAt(0);
            char c = str.charAt(left++);
            if(check(c)){
                count--;
            }
            c=str.charAt(j);
            sb.append(c);
            if(check(c)){
                count++;
            }
            if(count>max){
                max=count;
                ans=sb.toString();
            }
        }
        System.out.println(ans);
    }
    static  boolean check(char c){
        if(c=='G'||c=='C'){
            return true;
        }else {
            return false;
        }
    }
}