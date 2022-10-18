package a338.比特位计数;

/**
 * x=x&(x-1) 每次将x的最后一个1置0
 * 时间：O(nlogn) 每个整数需要logn
 */
class Solution2 {
    public int[] countBits(int n) {
//        Integer.bitCount()
        int[] ans=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            ans[i]=countOnes(i);
        }
        return ans;
    }
    public int countOnes(int x){
        int count=0;
        while (x>0){
            x=x&(x-1);
            count++;
        }
        return count;
    }
}