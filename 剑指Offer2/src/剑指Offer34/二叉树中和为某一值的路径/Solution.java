package 剑指Offer34.二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root==null){
            return res;
        }
        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        dfs(root,list,target);
        return res;
    }
    // 回溯dfs
        void dfs(TreeNode root,List<Integer> list,int target){
        if(root.left==null&& root.right==null){
            int total=0;
            for (Integer val : list) {
                total+=val;
            }
            if(total==target){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(root.left!=null){
            list.add(root.left.val);
            dfs(root.left,list,target);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            list.add(root.right.val);
            dfs(root.right,list,target);
            list.remove(list.size()-1);
        }
    }
}
