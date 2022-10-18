package 剑指Offer27.二叉树的镜像;

/**
 * 时间复杂度：O(N)，其中 NN 为二叉树节点的数目。我们会遍历二叉树中的每一个节点，对每个节点而言，我们在常数时间内交换其两棵子树。
 *
 * 空间复杂度：O(N)。使用的空间由递归栈的深度决定，它等于当前节点在二叉树中的高度。
 *  在平均情况下，二叉树的高度与节点个数为对数关系，即 O(\log N)。
 *  而在最坏情况下，树形成链状，空间复杂度为 O(N)。
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
