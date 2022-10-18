package 字节训练营.cron表达式解析;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cronEx=new String[5];
        for (int i = 0; i < 5; i++) {
            cronEx[i]=sc.next();
        }

    }
    void resolve(String ex,String type){
        if(ex.equals("*")){
            System.out.println();
        }
    }
    // 以秒为单位
    String resolveEx(String ex){
        if(ex.equals("minute")){
            System.out.println("分："+60);
            return "分";
        }
        if(ex.equals("hour")){
            System.out.println("时:"+60*60);
            return "时";
        }
        if(ex.equals("day")){
            System.out.println("天:"+60*60*24);
            return "天";
        }
        if(ex.equals("month")){
            System.out.println("月:"+60*60*24*30);
            return "月";
        }
        if(ex.equals("week")){
            System.out.println("周:"+60*60*24*7);
            return "周";
        }
        return null;
    }
    // 以秒为单位
    String resolveType(String type){
        if(type.equals("minute")){
            System.out.println("分："+60);
            return "分";
        }
        if(type.equals("hour")){
            System.out.println("时:"+60*60);
            return "时";
        }
        if(type.equals("day")){
            System.out.println("天:"+60*60*24);
            return "天";
        }
        if(type.equals("month")){
            System.out.println("月:"+60*60*24*30);
            return "月";
        }
        if(type.equals("week")){
            System.out.println("周:"+60*60*24*7);
            return "周";
        }
        return null;
    }
}
