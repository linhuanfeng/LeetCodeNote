package 剑指Offer57II.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

class Solution {
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
        int[][] ans=new int[tempList.size()][];
        for (int k = 0; k < tempList.size(); k++) {
            ans[k]=tempList.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = solution.findContinuousSequence(15);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}