package a406.根据身高重建队列;

import java.util.Arrays;

/**
 * 贪心
 *
 * 我们发现有两个维度，身高h和位置k，那么只能先确定一个维度，不然会顾此失彼
 *
 * 假设确定位置k，如果按k升序，那么身高会不满足条件，且不能再兼顾用到k值的结果
 * 如果先确定身高，那身高降序排列，那么k值就可以兼顾用到身高的结果
 *
 * 比如[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 步骤一：
 * 按身高降序后，k值升序，得到
 * 7,0  7,1  6,1  5,0  5,2  4,4
 *
 * 因为步骤一包装后面的元素都是小于等于前面的元素，所以元素往前移不会改变前面的k的正确性
 *
 * 步骤二：
 * 6，1移到第二，其它的后移 7,0  6,1  7,1    5,0  5,2  4,4
 * 5,0移到第一  5,0  7,0  6,1  7,1  5,2  4,4
 * 5,2移到 5,0  7,0 5,2   6,1  7,1  4,4
 *
 * 时间：O(nlogn) 排序的开销
 * 空间：O(1)
 *
 */
public class Solution2 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0]; // 身高降序
            }else {
                return a[1]-b[1];// k值升序
            }
        });

        // 进行步骤二
        for (int i = 0; i < people.length; i++) {
            if(people[i][1]!=i){
                // 插入正确的位置，
                int[] cur=people[i];
                System.arraycopy(people,people[i][1],people,people[i][1]+1,i-people[i][1]);
                people[cur[1]]=cur;
            }
        }
        return people;
    }

    public static void main(String[] args) {
        for (int[] ints : new Solution2().reconstructQueue(
                new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}
        )) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
