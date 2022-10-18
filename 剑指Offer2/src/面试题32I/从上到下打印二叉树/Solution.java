package 面试题32I.从上到下打印二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int[] ans=null;
        List<Integer> temp=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        int size=temp.size();
        ans=new int[size];
        for (int j = 0; j <size ; j++) {
            ans[j]=temp.get(j);
        }
        return ans;
    }
}