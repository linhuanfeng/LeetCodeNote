package 剑指Offer34.二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    // List<Integer>这里为什么换成LinkedList<Integer> 就编译失败了
    LinkedList<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;
    }
    // 回溯dfs
    void dfs(TreeNode root,int target){
        if(root==null){
            return;
        }
        path.addLast(root.val);
        target-=root.val;
        if(target==0&&root.left==null&& root.right==null){
            res.add(new LinkedList<>(path));
//            return; 注意这里不能加return了，不然导致后面的removeLast没有弹出结果，导致结果失败
        }
        dfs(root.left,target);
        dfs(root.right,target);
        path.removeLast();
    }
}
