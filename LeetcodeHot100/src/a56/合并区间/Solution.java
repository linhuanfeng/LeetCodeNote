package a56.合并区间;

import java.util.*;

/**
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 排序+双指针
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{intervals[0][0],intervals[0][1]});
        // 每次更新组后一个区间
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>list.get(list.size()-1)[1]){
                // 那么一定是新的区间
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }else {
                // 可以合并
                int[] remove = list.remove(list.size() - 1);
                remove[1]=Math.max(remove[1],intervals[i][1]);
                list.add(remove);
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] nums={{1,2},{3,4},{2,5}};
        int[][] merge = solution.merge(nums);

        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
//    public void quickSort(int[][] nums,int left,int right){
//        int i=left,j=right;
//        int[] key=new int[]{nums[i][0],nums[i][1]};
//        while (i<j){
//            while (i<j&&nums[j][0]>=key[0])j--;
//            if(nums[j][0]<nums[i][0]){
//                nums[i]=nums[j];
//                i++;
//            }
//            while (i<j&&nums[i][0]<=key[0])i++;
//            if(nums[i][0]>nums[j][0]){
//                nums[j]=nums[i];
//                j--;
//            }
//        }
//        nums[i]=key;
//        if(i-1>left)quickSort(nums,left,i-1);
//        if(i+1<right)quickSort(nums,i+1,right);
//    }