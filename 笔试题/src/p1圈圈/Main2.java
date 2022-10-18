package p1圈圈;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] dic={1,0,0,0,0,0,1,0,2,1};
        int ans=0;
        while (num!=0){
            ans+=dic[num%10];
            num/=10;
        }
        System.out.println(ans);
        sc.close();
    }
}
