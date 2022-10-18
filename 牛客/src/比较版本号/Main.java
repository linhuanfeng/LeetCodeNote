package 比较版本号;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().split("=")[1];
        String s2 = sc.nextLine().split("=")[1];

        String[] split = s1.split("\\.");
        int n1 = split.length;
        int[] a1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            String str = split[i];
            String str2 = "";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != '0') {
                    str2 += str.charAt(j);
                }
            }
            if (str2.equals("")) {
                a1[i] = 0;
            } else {
                a1[i] = Integer.valueOf(str2);
            }
        }

        String[] split2 = s2.split("\\.");
        int n2 = split2.length;
        int[] a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            String str = split2[i];
            String str2 = "";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != '0') {
                    str2 += str.charAt(j);
                }
            }
            if (str2.equals("")) {
                a2[i] = 0;
            } else {
                a2[i] = Integer.valueOf(str2);
            }
        }

        int i=0;
        while (i<n1&&i<n2){
            if(a1[i]==a2[i]){

            }else {
                System.out.println(a1[i]-a2[i]);
                return;
            }
            i++;
        }

        if(i<n1){
            while (i<n1){
                if(a1[i]!=0){
                    System.out.println(1);
                    return;
                }
                i++;
            }
        }

        if(i<n2){
            while (i<n2){
                if(a2[i]!=0){
                    System.out.println(-1);
                    return;
                }
                i++;
            }
        }

        System.out.println(0);

    }
}
