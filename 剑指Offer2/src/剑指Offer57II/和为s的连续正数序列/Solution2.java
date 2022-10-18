package 剑指Offer57II.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间：O(n)
 * 空间:i,j常数级别
 */
class Solution2 {
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2;
        int count=i+j;
        List<int[]> tempList=new ArrayList<>();
        while (j<target){
            if(count==target){
                int[] ints = new int[j-i+1];
                int k=0;
                for (int l=i;l<=j;l++) {
                    ints[k++]=l;
                }
                tempList.add(ints);
                count-=i;
                j++;
                count+=j;
                i++;
                continue;
            }
            if(count>target){
                count=count-i;
                i++;
            }else {
                j++;
                count=count+j;
            }
        }
        /**
         * 长度够直接拷贝，不够则new一个
         *     public <T> T[] toArray(T[] a) {
         *         if (a.length < size)
         *             // Make a new array of a's runtime type, but my contents:
         *             return (T[]) Arrays.copyOf(elementData, size, a.getClass());
         *         System.arraycopy(elementData, 0, a, 0, size);
         *         if (a.length > size)
         *             a[size] = null;
         *         return a;
         *     }
         */
        return tempList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] ints = solution.findContinuousSequence(15);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}