package 剑指Offer17.打印从1到最大的n位数;

public class Solution {
    public int[] printNumbers(int n) {
        int len=(int)Math.pow(10.0,n*1.0)-1;
        int[] res=new int[len];
        for (int i = 0; i <len ; i++) {
            res[i]=i+1;
        }
        return res;
    }
}
