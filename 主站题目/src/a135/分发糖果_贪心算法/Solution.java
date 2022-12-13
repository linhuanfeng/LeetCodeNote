package a135.分发糖果_贪心算法;

import java.util.Arrays;

/**
 * 贪心算法
 *
 * 有两个维度：大于左边和右边，因此只能先用一个维度去比较，不然会顾此失彼
 *
 * 2 1 0 2
 * 1 1 1 2 从左到右
 * 3 2 1 2 从右到左
 * 2 2×
 *
 * 时间：O（n）
 * 空间：O（1）
 */
class Solution {
    public int candy(int[] ratings) {
        int[] arr=new int[ratings.length];
//        Arrays.fill(arr,1);
        arr[0]=1;
        for (int i = 1; i < ratings.length ; i++) {
            if(ratings[i]>ratings[i-1]){
                arr[i]=arr[i-1]+1;
            }
        }
        for (int i = ratings.length-2; i >=0 ; i--) {
            if(ratings[i]>ratings[i+1]){
                arr[i]=Math.max(arr[i],arr[i+1]+1); // 满足左边和右边的大小关系
            }
        }
        return Arrays.stream(arr).sum();
    }
}