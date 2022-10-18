package a226.翻转二叉树;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null||root.left==null&&root.right==null)
            return root;
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}