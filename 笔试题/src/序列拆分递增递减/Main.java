package 序列拆分递增递减;

import java.util.Scanner;
// 18
public class Main {
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
    public static boolean dfs(int cur,int pre){
        if(cur==arr.length){
            return isReduce();
        }
        for (int i = cur; i < arr.length; i++) {
            if(arr[i]>pre){ // 递增
                vis[i]=true;
                if(dfs(i+1,arr[i])){
                    return true;
                }
                vis[i]=false;
            }
        }
        return false;
    }
    public static boolean isReduce(){
        int i=0,pre=0;
        for (; i < vis.length; i++) {
            if(!vis[i]){
                pre=arr[i];
                i++;
                break;
            }
        }
        for (; i < vis.length; i++) {
            if(!vis[i]){
                if(arr[i]>=pre){ // 不是递减
                    return false;
                }else {
                    pre=arr[i];
                }
            }
        }
        return true;
    }
}
