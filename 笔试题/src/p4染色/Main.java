package p4染色;

import java.util.Scanner;

// 1000000007
public class Main {
    static int[] arr=new int[4];
    static int ans=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(0,n);
        System.out.println(ans);
        sc.close();
    }
    static void dfs(int cur,int n){
        if(cur>3){
            ans++;
            ans=ans%1000000007;
            return;
        }
        for (int i = 1; i <=n ; i++) {
            if(isOk(cur,i)){
                arr[cur]=i;
                dfs(cur+1,n);
            }
        }
    }
    static boolean isOk(int cur,int v){
        if(cur==1)return arr[0]!=v;
        if(cur==2)return arr[0]!=v;
        if(cur==3)return arr[1]!=v&&arr[2]!=v;
        return true;
    }
}
