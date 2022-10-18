package p1圈圈;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] dic={1,0,0,0,0,0,1,0,2,1};
        int ans=0;
        for (int i = 0; i < str.length(); i++) {
            ans+=dic[str.charAt(i)-'0'];
        }
        System.out.println(ans);
        sc.close();
    }
}
