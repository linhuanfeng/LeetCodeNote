package a338.比特位计数;

class Solution {
    public int[] countBits(int n) {
//        Integer.bitCount()
        int[] ans=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            int t=i;
            while (t>0){
                if((t&1)==1)
                    ans[i]++;
                t=t>>1;
            }
        }
        return ans;
    }
}