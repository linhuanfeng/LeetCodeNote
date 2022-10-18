package 软通杯.第一题;

import java.util.Scanner;

public class Main {
    static int[][] litter=null;
    static int d=0; // 井的高度
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        d=scan.nextInt(); // 井的高度
        int g=scan.nextInt();
        litter=new int[g][3];
        for (int i = 0; i < g; i++) {
            for (int j = 0; j < 3; j++) {
                litter[i][j]=scan.nextInt();
            }
        }
        dfs(0,10,0,0);
        System.out.println(minTime!=Integer.MAX_VALUE?minTime:deadTime);
        scan.close();
    }
    static int minTime=Integer.MAX_VALUE; // 最早出来的时间
    static int deadTime=Integer.MIN_VALUE;// 死亡时间
    // cur:当前第几个垃圾 lastTime:存活时间 h:当前高度  lastStamp:上一次的时间间隔
    static void dfs(int cur,int live,int h,int lastStamp){
        if(cur>=litter.length){
            // 表示垃圾已经没了
            if(h>=d&&litter[cur-1][0]<minTime){
                // 大于井的高度，可以出来
                minTime=litter[cur-1][0];
            }
            // 如果此时出不来并且还没死
            deadTime=Math.max(deadTime,litter[cur-1][0]+live);
            return;
        }
//        if(live<=0){
//            int deadTemp = litter[cur - 1][0] - (live * (-1));
//            deadTime=Math.max(deadTime,deadTemp);
//            return;
//        }
        for (int i = 0; i < 2; i++) {
            // 上一次距离这次的时间点
            int distance = litter[cur][0] - lastStamp;
            if (distance>live){
                // 说明还坚持不到现在
                deadTime=Math.max(deadTime,lastStamp+live);
                continue;
            }
            if(i==0){
                // 判断是否能到当前时间
                // 0表示吃                              这段时间也在消耗血量
                dfs(cur+1,live+litter[cur][1]-distance,h,litter[cur][0]);
            }else {
                // 1表示垫高
                dfs(cur+1,live-distance,h+litter[cur][2],litter[cur][0]);
            }
        }
    }
}
