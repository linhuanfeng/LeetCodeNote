package p2;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] pay=new double[12];
        double maxIn=-1,maxOut=1;
        int maxInIndex=-1,maxOutIndex=-1;
        for (int i = 0; i <12 ; i++) {
            String[] split = sc.nextLine().split(":");
//            sc.nextLine();
            int j=Integer.valueOf(split[1]);
            for (int k = 0; k < j; k++) {
                String next = sc.next();
                String money = next.split(":")[1];
                if(money.charAt(0)=='+'){
                    pay[i]+=Double.valueOf(money.substring(1,money.length()));
                }else {
                    pay[i]-=Double.valueOf(money.substring(1,money.length()));
                }
            }
            if(i!=11) sc.nextLine();

            if(pay[i]>0) System.out.println(getMonth2(i)+":+"+String.format("%.2f",pay[i]));
            else System.out.println(getMonth2(i)+":"+String.format("%.2f",pay[i]));

            if(pay[i]>maxIn){
                maxIn= Math.max(maxIn,pay[i]);
                maxInIndex=i;
            }
            if(pay[i]<maxOut){
                maxOut= Math.min(maxOut,pay[i]);
                maxOutIndex=i;
            }
        }
        System.out.println(getMonth2(maxOutIndex)+" "+getMonth2(maxInIndex));
        sc.close();
    }
    static String getMonth2(int month) {
        if (month == 0) return "January";
        if (month == 1) return "February";
        if (month == 2) return "March";
        if (month == 3) return "April";
        if (month == 4) return "May";
        if (month == 5) return "June";
        if (month == 6) return "July";
        if (month == 7) return "August";
        if (month == 8) return "September";
        if (month == 9) return "October";
        if (month == 10) return "November";
        if (month == 11) return "December";
        return "";
    }
}
//    static int getMonth(String str){
//        if(str.startsWith("Jan"))return 0;
//        if(str.startsWith("Feb"))return 1;
//        if(str.startsWith("Mar"))return 2;
//        if(str.startsWith("Apr"))return 3;
//        if(str.startsWith("May"))return 4;
//        if(str.startsWith("Jun"))return 5;
//        if(str.startsWith("July"))return 6;
//        if(str.startsWith("Aug"))return 7;
//        if(str.startsWith("Sep"))return 8;
//        if(str.startsWith("Oct"))return 9;
//        if(str.startsWith("Nov"))return 10;
//        if(str.startsWith("Dec"))return 11;
//        return -1;
//    }
