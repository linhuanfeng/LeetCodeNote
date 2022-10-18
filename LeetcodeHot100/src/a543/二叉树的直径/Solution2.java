package a543.二叉树的直径;

/**
 * 路径最长的任意两个结点
 * 思路：找每个结点的做子树和右子树的高度之和-1
 */
class Solution2 {
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root); // 左右子树的高度之和恰好等于当前结点的直径
        return ans;
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lh=dfs(root.left); // 左结点为根的高度
        int rh=dfs(root.right);// 右结点为根的高度
        ans=Math.max(ans,lh+rh);
        return Math.max(lh,rh)+1;
    }
}