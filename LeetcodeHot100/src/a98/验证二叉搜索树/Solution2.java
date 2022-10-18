package a98.验证二叉搜索树;

/**
 * 采用递归的方式
 */
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     *
     * @param node
     * @param lower 最小的值
     * @param upper 最大的值
     * @return
     */
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }                                                     // 右子树的不能大于当前结点的上界
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node2.left=node1;
        node2.right=node3;
        node1.right=node4;
        System.out.println(solution2.isValidBST(node2));
    }
}