package a102.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> que=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
        que.offer(root);
        while (!que.isEmpty()){
            List<Integer> list=new ArrayList<>();
            for (int i = que.size(); i>0  ; i--) {
                TreeNode poll = que.poll();
                list.add(poll.val);
                if(poll.left!=null)que.offer(poll.left);
                if(poll.right!=null)que.offer(poll.right);
            }
            ans.add(list);
        }
        return ans;
    }
}