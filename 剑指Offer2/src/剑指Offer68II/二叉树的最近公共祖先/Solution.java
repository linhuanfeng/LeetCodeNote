package 剑指Offer68II.二叉树的最近公共祖先;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * 自底向上递归
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root.val==p.val||root.val==q.val){
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left==null&&right==null){
            return null;
        }else if(left!=null&&right==null){
            return left;
        }else if(left==null&&right!=null){
            return right;
        }else {
            return root;
        }
    }
}