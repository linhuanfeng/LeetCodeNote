package 试题H回忆迷宫;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(),x,y;
        int a=Integer.MAX_VALUE,b=Integer.MIN_VALUE,c=Integer.MAX_VALUE,d=Integer.MIN_VALUE;
        String str = sc.next();
        boolean[][] ans=new boolean[2*N+1][2*N+1];
        boolean[][] hasPrint=new boolean[2*N+1][2*N+1];
        // 从ans[N][N]开始走
        x=N;
        y=N;
        ans[x][y]=true;
        for (int i = 0; i <N ; i++) {
            if(str.charAt(i)=='R'){
                y++;
            }else if(str.charAt(i)=='D'){
                x++;
            }else if(str.charAt(i)=='L'){
                y--;
            }else {
                x--;
            }
            a=Math.min(a,x);
            b=Math.max(b,x);
            c=Math.min(c,y);
            d=Math.max(d,y);
            ans[x][y]=true;
        }
//        ans[a-1][c-1]=true;
//        ans[a-1][d+1]=true;
//        ans[b+1][c-1]=true;
//        ans[b+1][d+1]=true;
//        for (int i = a-1; i <=b+1 ; i++) {
//            for (int j = c-1; j <=d+1 ; j++) {
//                if(ans[i][j])System.out.print(" ");
//                else System.out.print("*");
//            }
//            System.out.println();
//        }
        for (int i = 0; i < ans.length-1; i++) {
            boolean tag=false;
            for (int j = 0; j < ans[0].length-1; j++) {
                if(ans[i][j]){
                    tag=true;
                    System.out.print(" ");
                    hasPrint[i][j]=true;
                }
                else {
                    if(isOk(i,j,ans)){
                        tag=true;
                        System.out.print("*");
                        hasPrint[i][j]=true;
                    }else {
                        if(ans[i+1][j+1]||(i-1>=0&&ans[i-1][j+1])) {
                            System.out.print(" ");
                            hasPrint[i][j]=true;
                        }else {
                            if(j-1>=0&&hasPrint[i][j-1]&&isOk(i,j+1,ans)) System.out.print("*");
                        }
                    }
                }
            }
            if(tag) System.out.println();
        }
        sc.close();
    }
    static boolean isOk(int x,int y,boolean[][] ans){
        int[] dx={0,1,0,-1},dy={1,0,-1,0};
        for (int i = 0; i < 4; i++) {
            int tx=x+dx[i];
            int ty=y+dy[i];
            if(tx>=0&&tx<ans.length&&ty>=0&&ty<ans.length){
                if(ans[tx][ty]){
                    // 有一面靠近路
                    return true;
                }
            }
        }
        return false;
    }

}
