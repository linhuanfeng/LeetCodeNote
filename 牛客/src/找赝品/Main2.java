package 找赝品;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 排个序
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur=sc.nextInt();
        }
        System.out.println(n-map.get(max));
    }
}
