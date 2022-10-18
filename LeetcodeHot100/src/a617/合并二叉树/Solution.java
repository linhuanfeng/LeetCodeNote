package a617.合并二叉树;

/**
 * 深度优先遍历
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果一个为空，返回不为空的那个即可
        if(root1==null)return root2;
        if(root2==null)return root1;
        // 两个都不为空，进行合并
        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left=mergeTrees(root1.left,root2.left);
        merge.right=mergeTrees(root1.right,root2.right);
        return merge;
    }
}