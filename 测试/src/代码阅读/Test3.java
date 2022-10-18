package 代码阅读;

/**
 * 将a升序排序
 */
public class Test3 {
    public static void main(String[] args) {
        int[] a={2,4,1};
        func(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
    static void func(int[] arr){
        if(arr[0]>arr[1]){
            swap(arr,0,1);
        }
        if(arr[1]>arr[2]){
            swap(arr,1,2);
        }
        if(arr[0]>arr[1]){
            swap(arr,0,1);
        }
    }
    static void swap(int[] arr,int i,int j){
        int k=arr[i];
        arr[i]=arr[j];
        arr[j]=k;
    }
}
