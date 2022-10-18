package a39.组合总和;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0,candidates,target,new ArrayList<>());
        return res;
    }
    private void dfs(int cur,int[] candidates,int total,List<Integer> list){
        if(total==0){
            res.add(new ArrayList<>(list));
        }
        // 每次都只能当前取或向后取,防止重复
        for (int i = cur; i <candidates.length ; i++) {
            int last=total-candidates[i];
            if(last>=0){
                list.add(candidates[i]);
                dfs(i, candidates, last, list);
                list.remove(list.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={2,3,5};
        int target=8;
        List<List<Integer>> lists = solution.combinationSum(nums, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}