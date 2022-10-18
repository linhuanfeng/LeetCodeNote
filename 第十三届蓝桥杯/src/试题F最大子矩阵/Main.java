package 试题F最大子矩阵;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),M=sc.nextInt(),limit=-1,ans=Integer.MIN_VALUE;
        int[][] arr=new int[N][M];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j]=sc.nextInt();
            }
            sc.nextLine();
        }
        limit=sc.nextInt();
        for (int i = 0; i <N ; i++) { // 行1
            for (int j = i; j <N ; j++) { // 行2
                for (int k = 0; k < M; k++) { // 列1
                    for (int l = k; l < M; l++) { // 列2
                        if(isOk(i,j,k,l,arr,limit)){
                            ans=Math.max(ans,(j-i+1)*(l-k+1));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
    static boolean isOk(int i,int j,int k,int l,int[][] arr,int limit){
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int m = i; m <= j; m++) {
            for (int n = k; n <=l ; n++) {
                max=Math.max(max,arr[m][n]);
                min=Math.min(min,arr[m][n]);
            }
        }
        return max-min<=limit;
    }
}
