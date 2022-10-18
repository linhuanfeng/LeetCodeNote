package 不重复的全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 只通过部分用例，有重复元素
 */
public class Solution {

    public int[][] UniquePerm (int[] nums) {
        // write code here
        int n=nums.length;
        vis=new boolean[n];
        Arrays.sort(nums);
        dfs(nums,new int[n],0);
        return ans.toArray(new int[ans.size()][]);
    }
    boolean[] vis;
    List<int[]> ans=new ArrayList<>();
    void dfs(int[] nums,int[] temp_arr,int k){
        if(k==nums.length){
            ans.add(Arrays.copyOf(temp_arr,temp_arr.length));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                if(k==0){ // 去重
                    if(i>0&&nums[i]==nums[i-1]){
                        continue;
                    }
                }
                vis[i]=true;
                temp_arr[k]=nums[i];
                dfs(nums,temp_arr,k+1);
                vis[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int[] ints : solution.UniquePerm(new int[]{3, 3, 4})) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}