package 淘汰分数;
/**
 * 美团校招2021校招笔试
 * 通过百分之90
 */

import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        x=sc.nextInt();
        y=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        quickSort(arr,0,n-1);

        /**
         由于1<=x<=y<=n,所以至少会淘汰一人，
         从arr[x]处开始判断，
         但注意x不一定满足条件（有可能n-x不在区间范围内，或者x之后的数等于x）
         为了让淘汰的尽量少，
         假设初始有n-1人晋级
         从左开始遍历
         **/
        for(int i=x-1;i<n;i++){
            if(check(i+1)){
                while(i+1<n&&arr[i+1]==arr[i]){
                    // 找到当前分值最后的下标
                    i++;
                }
                if(check(i+1)){
                    // 还满足的话，那就是真满足了
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
    static int n,x,y;
    static void quickSort(int[] arr,int left,int right){
        int i=left,j=right,key=arr[i];
        while(i<j){
            while(i<j&&arr[j]>=key){
                j--;
            }
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            while(i<j&&arr[i]<=key){
                i++;
            }
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=key;
        if(i+1<right){
            quickSort(arr,i+1,right);
        }
        if(i-1>left){
            quickSort(arr,left,i-1);
        }
    }
    static boolean check(int i){
        if(i>=x&&i<=y&&n-i>=x&&n-i<=y){
            return true;
        }else{
            return false;
        }
    }
}