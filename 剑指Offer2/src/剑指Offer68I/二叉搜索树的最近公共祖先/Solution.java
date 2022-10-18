package 剑指Offer68I.二叉搜索树的最近公共祖先;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

/**
 * 时间：O（n）,每循环一层，排除一层，二叉树的高度为O(logn),退化成链表则为O(n)
 * 空间：O(1)
 *
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(root.val>p.val&&root.val>q.val){
                // 最近公共祖先在左子树中
                root=root.left;
            }else if(root.val<p.val&&root.val<q.val){
                // 最近公共祖先在右子树中
                root=root.right;
            }else {
                return root;
            }
        }
        return null;
    }
}