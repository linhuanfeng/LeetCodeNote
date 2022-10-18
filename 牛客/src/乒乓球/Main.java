package 乒乓球;

import java.util.Scanner;

/**
 * 乒乓球，被称为中国的“国球”，是一种世界流行的球类体育项目。一局比赛的获胜规则如下：
 * 当一方赢得至少11分，并且超过对方2分及以上时，获得该局的胜利。
 * 按照上述规则，小美和小团正在进行一局比赛，当前比赛尚未结束，此时小美的得分为a，小团的得分为b。小美想知道，在
 * 最理想的情况下，她至少还要得多少分才可以赢下这场比赛。
 * 输入描述
 * 输入两个整数a、b。a表示当前小美获得的分数，b表示小团的分数。
 * 0≤ a,b≤ 99.保证输入的比分合法，并且在该比分下比赛尚未结束。
 *
 * 输出猫述
 * 输出一个整数，表示小美至少还要得多少分才能获得这局比赛的胜利。
 *
 * input:
 * 30 31
 *
 * output:
 * 3
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();

        if(a>=11&&a-b>=2){
            System.out.println(0);
        }else {
            // a=11 b=10 /a=10 b=8  a=10 b=9
            System.out.println(Math.max(11,b+2)-a);
        }

        // 91%
//        if(a>b){ // 还未结束
//            if(t>=11){ // 大于2的数大于11
//                ans=t-a;
//            }else {
//                ans=11-a;
//            }
//            System.out.println(ans);
//            return;
//        }
//
//        ans=t-a;
//        if(t<11){
//            ans+=11-ans;
//        }
//        System.out.println(ans);
    }
}
