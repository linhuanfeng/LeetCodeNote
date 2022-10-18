package 试题E求阶乘;

import java.util.Scanner;

// 试题 E: 求阶乘
public class Main {
    public static void main(String[] args) {
        /**
         * 2
         * 10!=3628800
         */
        long ans=1;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(),p=1;
        for (int i = 0; i < k; i++) {
            p=p*10;
        }
        for (int i = 1;; i++) {
            ans=ans*i%(p*10); // 只需要看后k位
            if(isOk(ans,p)){
                System.out.println(i);
                sc.close();
                return;
            }
        }
    }
    static boolean isOk(long a,int p){
        if(a<p)return false;
        if(a/p==0)return false;
        if(a%p==0)return true;
        return false;
    }
}
