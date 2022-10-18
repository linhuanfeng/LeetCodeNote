package 序列拆分递增递减;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给出一个由正整数组成的序列。请判断能否将其中的每个数染成红色或蓝色，使得染成红色的数按顺序构成一个单调递增的序列，且染成蓝色的数按顺序构成一个单调递减的序列。
 *
 *
 *
 * 输入描述
 * 第一行有一个正整数T(1<=T<=10)，代表测试数据的组数。
 *
 * 每组测试数据的第一行有一个正整数n(1<=n<=500)，代表序列的长度。
 *
 * 第二行有n个互不相同的范围在1到n之间的正整数，代表该序列。
 *
 * 输出描述
 * 若可以按给出的规则染色，则输出Yes，否则输出No。
 *
 *
 * 样例输入
 * 3
 * 6
 * 3 6 5 1 4 2
 * 7
 * 7 4 1 3 2 5 6
 * 6
 * 1 4 3 6 5 2
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T= sc.nextInt();
        for (int i = 0; i < T; i++) {
            int count= sc.nextInt();
            arr=new int[count];
            vis=new boolean[count];
            for (int j = 0; j < count; j++) {
                arr[j]= sc.nextInt();
            }
            boolean tag=false;
            for (int j = 0; j < count; j++) {
                vis[j]=true;
                if(dfs(j+1,arr[j])){
                    System.out.println("Yes");
                    tag=true;
                    break;
                }
                vis[j]=false;
            }
            if(!tag)
                System.out.println("No");
        }
    }
    private static int[] arr;
    private static boolean[] vis;
    Deque<Integer> stack=new LinkedList<>();
    static boolean isFirst=true;
    static int Min=0;
    public static boolean dfs(int cur,int pre){
        if(cur==arr.length){
            return true;
        }
        for (int i = cur; i < arr.length; i++) {
            if(arr[i]>pre){ // 递增
                vis[i]=true;
                if(dfs(i+1,arr[i])){
                    return true;
                }

                vis[i]=false;
                Min=arr[i];
            }else {
                if(!isFirst&&arr[i]>=Min){ // 不是第一个
                    return false;
                }else {
                    isFirst=false;
                    Min=arr[i];
                }
            }
        }
        return false;
    }
//    public static boolean isReduce(){
//        int i=0,pre=0;
//        for (; i < vis.length; i++) {
//            if(!vis[i]){
//                pre=arr[i];
//                i++;
//                break;
//            }
//        }
//        for (; i < vis.length; i++) {
//            if(!vis[i]){
//                if(arr[i]>=pre){ // 不是递减
//                    return false;
//                }else {
//                    pre=arr[i];
//                }
//            }
//        }
//        return true;
//    }
}
