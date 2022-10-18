package a543.二叉树的直径;

/**
 * 路径最长的任意两个结点
 * 思路：找每个结点的做子树和右子树的高度之和-1
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int cur=dfs(root.left)+dfs(root.right); // 左右子树的高度之和恰好等于当前结点的直径
        int lf=diameterOfBinaryTree(root.left); // 这些多余了，因为求当前结点的深度的时候，所有子树的深度都求过了
        int rt=diameterOfBinaryTree(root.right);
        return Math.max(cur,Math.max(lf,rt));
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lh=dfs(root.left)+1;
        int rh=dfs(root.right)+1;
        return Math.max(lh,rh);
    }
}