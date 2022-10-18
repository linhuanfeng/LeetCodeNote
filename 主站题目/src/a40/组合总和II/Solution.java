package a40.组合总和II;

import java.util.*;

/**
 * 每个数只能用一次，不能包含重复的解集
 *
 * 回溯+去重（剪枝） 去重是关键，使用排序
 *
 * 如何去重：排序+同一层相同的数只能取一次，如果和前一个相同，那么说明同一层已取过该数了，再取就要重复了
 *
 * 使用候选数组法，对同一层的进行剪枝，
 *
 * 剪枝一：先排序，如果当前数大于target，那么后面更大于target，所以剪枝
 * 剪枝二：1 2 2   1 2（第二个）和 1 2（第三个）一定会重复，他们属于同一层，用一个冗余的candidate数组。
 *      具体操作，if(i>begin)说明当前是同一层，那么判断candidate[i]和candidate[i-1]是否相等，相等会导致重复，所以剪枝
 *
 *
 * 时间：O(n*2^n) 从每个结点就是数的深度搜索
 * 空间：O(n)临时数组
 * */
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序，基于排序去重
        Arrays.sort(candidates);
        dfs(candidates,target,new ArrayDeque<>(candidates.length),0);
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();

    /**
     *
     * @param candidates 排好序的
     * @param target
     * @param deque
     * @param begin
     */
    void dfs(int[] candidates, int target, Deque<Integer> deque, int begin){
        if(target==0){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i <candidates.length ; i++) {
            // 剪枝一
            if(candidates[i]>target){
                continue; // 后面更加大于candidates
            }
            // 剪枝二 同一层，相同的数只能取一次
            if(i>begin&&candidates[i]==candidates[i-1]){
                continue;
            }
            deque.addLast(candidates[i]);
            dfs(candidates,target-candidates[i] ,deque,i+1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        for (List<Integer> list : new Solution().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
