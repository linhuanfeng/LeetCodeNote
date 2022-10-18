package a236.二叉树的最近公共祖先;

/**
 * 1、当p,q位于root的左右子树时，root即为最近公共祖先
 * 2、当p等于root,且q为root的左子树或有子树中时，p为最近公共祖先
 * 3、同2，当q等于root,且p为root的左子树或有子树中时，q为最近公共祖先
 *
 * 考虑先序遍历，返回各自的公共祖先，
 * 1、当left和righ都不为null,root为最近公共祖先
 * 2、当left=null,right!=null right就是最近公共祖先
 * 3、同2
 *
 * 时间：递树退化成链表，递归的深度O(n)
 * 空间:树退化成链表，递归的深度O(n)
 *
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        if(root==p||root==q)return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null&&right!=null){
            return root;
        }else if(left!=null){
            return left;
        }else {
            return right;
        }
    }
}