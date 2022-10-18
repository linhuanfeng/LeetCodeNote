package 连续子数组数量;

import java.util.ArrayList;

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param a int整型ArrayList 
     * @param x int整型 
     * @return int整型
     */
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        int weight=1;
        long ans=0;
        for (int i = 0; i < x; i++) {
            weight*=10;
        }
        // write code here
        for (int i = 0; i < a.size(); i++) {
            long t=1;
            int count0=0;
            for (int j = i; j < a.size(); j++) {
                t=t%weight;
                // 和当前数相乘
                t=t*a.get(j);
                long[] longs = delete0(t); // 削去t的0
                count0+=longs[0];
                t=longs[1];
                if(count0>=x){
                    ans++;
                }
            }
        }
        return (int) ans;
    }
    int count0(long i){
        int ans=0;
        while (i>1){
            if(i%10==0){
                i/=10;
                ans++;
            }else {
                break;
            }
        }
        return ans;
    }
    long[] delete0(long i){
        int ans=0;
        while (i>1){
            if(i%10==0){
                i/=10;
                ans++;
            }else {
                break;
            }
        }
        return new long[]{ans,i};
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(50);
        list.add(4);
        System.out.println(new Solution2().getSubarrayNum(list, 2));
    }
}