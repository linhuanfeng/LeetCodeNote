package 试题C字符统计;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr=new int[26];
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int max=-1;
        for (int i = 0; i < next.length(); i++) {
            arr[next.charAt(i)-'A']++;
            max=Math.max(max,arr[next.charAt(i)-'A']);
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==max){
                System.out.print((char)(i+'A'));
            }
        }
        sc.close();
    }
}
