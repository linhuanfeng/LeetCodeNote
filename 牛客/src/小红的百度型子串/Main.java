package 小红的百度型子串;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        boolean[] arr=new boolean[26];
        // aeiou 原因true
        arr['a'-'a']=true;
        arr['e'-'a']=true;
        arr['i'-'a']=true;
        arr['o'-'a']=true;
        arr['u'-'a']=true;

        int ans=0;
        for (int i = 0; i <= line.length() - 5; i++) {
            boolean[] arr2=new boolean[26];
            if(arr[line.charAt(i)-'a']||arr[line.charAt(i+3)-'a']){ // 辅音
                continue;
            }
            if(!arr[line.charAt(i+1)-'a']||!arr[line.charAt(i+2)-'a']
                    ||!arr[line.charAt(i+4)-'a']){
                continue;
            }
            boolean tag=false;
            for (int j = 0; j < 5; j++) {
                if(arr2[line.charAt(i+j)-'a']){
                    tag=true;
                    break;
                }else {
                    arr2[line.charAt(i+j)-'a']=true;
                }
            }
            if(!tag){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
