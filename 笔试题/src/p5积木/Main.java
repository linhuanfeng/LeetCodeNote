package p5积木;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),m=0;
        int[] src=new int[n],tar=null;
        for (int i = 0; i < n; i++) {
            src[i]=sc.nextInt();
        }
        m=sc.nextInt();
        tar=new int[m];
        for (int i = 0; i < m; i++) {
            tar[i]=sc.nextInt();
        }
        System.out.println(count(n-1,m-1,src,tar,0));
    }
    static int count(int n,int m,int[] src,int[] tar,int hasCount){
        int i=n,j=m,prei=n;
        while (i>=0&&j>=0){
            if(src[i]==tar[j]){
                i--;
                j--;
            }else {
                // 右出一个
                i=prei-1;
                prei--;
                j=m; // j重置
            }
        }
        if(i<0&&j>=0){
            // j还有剩余
            return hasCount+n-prei+j+1;
        }else if(i>=0&&j<0){
            // prei不对，重新n进行递归
            return hasCount+count(prei-1,m,src,tar,hasCount+1);
        }else {
            return hasCount+n-prei;
        }
    }
}
