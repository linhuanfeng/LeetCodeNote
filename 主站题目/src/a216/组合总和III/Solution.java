package a216.组合总和III;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 指定k个数，可取值为1-9不能充重复取，和为n
 *
 * 如何去重，规定只能当前取或向后取 比如 1 2  再取 2 1的话就重复了
 *
 *  时间：O（n!）但是会剪枝
 *  空间：O（n）栈深度或者deque队列的长度
 */
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k,n,1,new ArrayDeque<>());
        return ans;
    }
    List<List<Integer>> ans=new ArrayList<>();

    /**
     *
     * @param k 总共k个数
     * @param n 和为n
     * @param begin 当前取值只能大于等于begin
     * @param deque 结果暂存
     */
    void dfs(int k, int n, int begin, Deque<Integer> deque){
        if(k==0){
            if(n==0){
                ans.add(new ArrayList<>(deque));
            }
            return;
        }
        for (int i = begin; i <=9 ; i++) {
            // 剪枝，后面更大于n
            if(i>n){
                break;
            }
            deque.addLast(i);
            dfs(k-1,n-i,i+1,deque);
            deque.removeLast();
        }
    }
}