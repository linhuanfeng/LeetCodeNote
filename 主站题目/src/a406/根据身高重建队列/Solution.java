package a406.根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思想：对于这种数对，技巧就是位置1升序，位置2降序，或位置降序，位置2升序
 * 原因，假设位置1降序，位置2升序，那么第i个元素前面就有i-1个大于等于i的数，
 *  同时，位置2大的放在后面可以可以减少插入次数和并保证准确性（
 *  比如【4，3】，【4，2】，那么当【4，3】放好的时候，前面就有三个大于等于的数，此时，插入【4，2】应放在【4，3】前面，导致【4，3】前面有4个而出错）
 */
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(arr1,arr2)->{ // 数对1升序，数对2降序
            if(arr1[0]==arr2[0]){
                return arr1[1]-arr2[1];
            }else {
                return arr2[0]-arr1[0];
            }
        });
        List<int[]> list=new ArrayList<>();
        list.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            list.add(people[i][1],people[i]); // 每次people[i][1]就是要插入的位置
        }
        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Solution solution = new Solution();
//        for (int[] ints : solution.reconstructQueue(people)) {
//            System.out.println(ints[0]+" "+ints[1]);
//        }
        for (int[] ints : solution.reconstructQueue(people)) {
            System.out.println(ints[0]+" "+ints[1]);
        }
    }
}