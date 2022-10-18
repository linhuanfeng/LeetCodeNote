package 剑指Offer62.圆圈中最后剩下的数字;

class Solution {
    public int lastRemaining(int n, int m) {
        int[] vis=new int[n];
        int count=n;
        for (int i = 0; i < n; i++) {
            vis[i]=i;
        }
        int t=0;
        while (true){
            if(count==1){
                // 删够了
                break;
            }
            if(vis[t]==-1){
//                t=t+count
            }
            t++;
//            if(t)
        }
        for (int i = 0; i < n; i++) {
            t++;

        }
        return 0;
    }
}