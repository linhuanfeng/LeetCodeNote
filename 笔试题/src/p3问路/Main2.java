package p3问路;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m = sc.nextInt(),q=0;
        boolean[][] has=new boolean[n+1][n+1];
        int[] arr=new int[m];
        for (int i = 0; i < m; i++) {
            arr[i]=sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int tar = sc.nextInt();
            has[arr[i]][tar]=has[tar][arr[i]]=true;
        }
        q=sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(has[a][b]) System.out.println("Yes");
            else System.out.println("No");
        }
        sc.close();
    }
}
