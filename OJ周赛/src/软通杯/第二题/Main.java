package 软通杯.第二题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] res=new int[2][2]; // 最小
        int a=-1,b=-1;
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        boolean tag=true;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while (l<r&&!isPrime(l)){
            l++;
        }
        if(l==r){
            System.out.println("no");
        }else {
            a=l;
            b=l;
        }
        for (int i = l+1; i <=r ; i++) {
            if(isPrime(i)){
                a=b;
                b=i;
            }
            if(a!=b){
                if(b-a<min){
                    min=b-a;
                    res[0][0]=a;
                    res[0][1]=b;
                }
                if(b-a>max){
                    max=b-a;
                    res[1][0]=a;
                    res[1][1]=b;
                }
            }
        }
        if(b!=a){
            System.out.println(res[0][0]+","+res[0][1]+" "+res[1][0]+","+res[1][1]);
        }
    }

    public static boolean isPrime(int n)
    {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n%2==0) return false;

        for(int i = 3; i*i <= n; i += 2)
            if(n%i == 0) return false;
        return true;
    }
}
