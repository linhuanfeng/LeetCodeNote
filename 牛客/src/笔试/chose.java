package 笔试;

import java.util.Scanner;

public class chose {
//    public void doFuc(String s){
//
//    }
//    public String three(String s,int start){
//        if(s.length()-start<3){
//            return s;
//        }
//        StringBuilder sb = new StringBuilder();
//        if(s.charAt(start)==s.charAt(start+1)&&s.charAt(start+1)==s.charAt(start+2)){
//            sb.deleteCharAt()
//        }
//    }
    public static void deleteThree(StringBuilder sb, int start){
        if(sb.length()-start<3){
            return;
        }
        if(sb.charAt(start)==sb.charAt(start+1)&&sb.charAt(start+1)==sb.charAt(start+2)){
            // aaa
            sb.deleteCharAt(start+1);
            deleteThree(sb,start);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            int start=0;
            if(sb.length()-start<3){
                System.out.println(sb);
                continue;
            }
            do{
                deleteThree(sb,start);
                if(sb.length()-start>=4&&sb.charAt(start)==sb.charAt(start+1)&&sb.charAt(start+2)==sb.charAt(start+3)){
                    // aaa
                    sb.deleteCharAt(start+2);
                }
                start++;
            }while (start<sb.length()-2);
            System.out.println(sb);
        }
        scanner.close();
    }
}
