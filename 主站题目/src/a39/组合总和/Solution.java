package a39.组合总和;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 每个数可以无限制的取
 * 采用回溯的方式，每次可以取当前值或下一个值，枚举所有的情况
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //
        ans=new ArrayList<>();
        dfs(candidates,0,target,new ArrayList<>());
        return ans;
    }
    List<List<Integer>> ans;

    /**
     * 每次只能当前取或向后取
     * @param candidates
     * @param target
     */
    void dfs(int[] candidates,int index,int target,List<Integer> list){
        if (target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if(candidates[i]<=target){
                list.add(candidates[i]);
                dfs(candidates, i, target-candidates[i], list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (List<Integer> list : solution.combinationSum(new int[]{2,3,6,7}, 7)) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}