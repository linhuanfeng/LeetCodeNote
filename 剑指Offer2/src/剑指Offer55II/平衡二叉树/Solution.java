package 剑指Offer55II.平衡二叉树;

/**
 *时间：O(nlogn)
 * 空间：深度O(n)退化成链表
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        // 自顶向下，既要判断当前是不是平衡二叉树，也要判断子树是否满足
        return Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    private int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftH = getHeight(node.left) + 1;
        int rightH = getHeight(node.right) + 1;
        return Math.max(leftH,rightH);
    }
}