package p2士兵;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i]=sc.next()+"#";
        }
        for (int i = 0; i < n; i++) {
            strs[i]+=sc.next();
        }
        Arrays.sort(strs,(a,b)->{
            String[] splita = a.split("#");
            String[] splitb = b.split("#");
            if(splita[0].compareTo(splitb[0])==0){
                return splita[1].compareTo(splitb[1]);
            }else return splita[0].compareTo(splitb[0]);
        });
        for (String str : strs) {
            System.out.print(str.split("#")[1]+" ");
        }
        sc.close();
    }
}
