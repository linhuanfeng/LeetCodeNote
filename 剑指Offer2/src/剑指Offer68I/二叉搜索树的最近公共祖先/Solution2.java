package 剑指Offer68I.二叉搜索树的最近公共祖先;

/**
 * 递归解法
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root.val>p.val&&root.val>q.val){
                // 最近公共祖先在左子树中
                return lowestCommonAncestor(root.left,p,q);
            }else if(root.val<p.val&&root.val<q.val){
                // 最近公共祖先在右子树中
                return lowestCommonAncestor(root.right,p,q);
            }
            return root;
    }
}

