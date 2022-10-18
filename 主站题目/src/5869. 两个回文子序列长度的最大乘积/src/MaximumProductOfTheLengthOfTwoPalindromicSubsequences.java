import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(maxProduct("bb"));
    }

    public static int maxProduct(String s) {
        int arrLen=1<<s.length();
        List<Integer> list=new ArrayList<>();
        int max=0;
        for (int i = 1; i < arrLen; i++) {
            if(isHuiWen(s,i)){
                list.add(i);
            }
        }
        Integer[] arr=new Integer[list.size()];
        arr=list.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if((arr[i]&arr[j])==0){// 不相交
                    max=Math.max(max,Integer.bitCount(arr[i])*Integer.bitCount(arr[j]));
                }
            }
        }
        return max;
    }
    static boolean isHuiWen(String s,int n){
        int start=0,end=s.length()-1;
        char[] charArray = s.toCharArray();
        while(start<end){
            while (start<end&&(n&1<<start)==0){// 从右边找到第一个不为0的数
                start++;
            }
            while (start<end&&(n&1<<end)==0){
                end--;
            }
            if(charArray[s.length()-start-1]!=charArray[s.length()-end-1]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
