package 剑指Offer68II.二叉树的最近公共祖先;

/**
 * 自底向上递归
 * 当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
 * 当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
 * 当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
 *      p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
 *      p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
 * 当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val||root.val==q.val){
            // 当前结点一个是目标结点
            return root;
        }
        // 自底向上返回目标结点，不存在则返回null
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        if(left==null){
            // 左子树为空，说明都在右侧
            return right;
        }
        if(right==null){
            return left;
        }
        // 左右子树都不为空，则当前为最近公共祖先
        return root;
    }
}