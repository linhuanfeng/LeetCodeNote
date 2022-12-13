package a452.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心+排序
 *
 * 根据第一个元素降序排序
 * 每个数的最右边边界一定要有一只箭
 *
 *
 * [10,16],[2,8],[1,6],[7,12]
 * 1，6
 *  2，  8
 *     7     12
 *        10    16
 *
 *
 * [10,16],[2,8],[1,6],[7,12],[7,8]
 * 1，6
 *  2，   8
 *     7 8
 *     7      12
 *         10    16
 *
 *  和前一个如果有交集，并且points[i][0]<=arrow,那么覆盖，并且更新arrow为新的最小值
 *  否则就是得开新箭了
 *
 * [1,2],[2,3],[3,4],[4,5]
 * 1,2
 *   2,3
 *     3,4
 *       4,5
 *
 * 1,2  3,4  5,6  7,8
 * 1,2
 *    3,4
 *       5,6
 *          7,8
 *
 * 时间：O(n)
 * 空间：O(1)
 *
 */
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0])); // 注意不能a[0]-b[0] 因为Integer.MINVALUE-Integer.MAXVALUE越界

        int arrow=points[0][1]; // 第一次箭射的位置
        int res=1;

        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=points[i-1][1]
                &&points[i][0]<=arrow){ // 和前一个如果有交集，那么覆盖，
                arrow=Math.min(arrow,points[i][1]);
            }else {
                arrow=points[i][1]; // 使用新的值
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinArrowShots(
//                new int[][]{{10,16},{2,8},{1,6},{7,12}}
//                new int[][]{{1,2},{3,4},{5,6},{7,8}}
                new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}
        ));
    }
}