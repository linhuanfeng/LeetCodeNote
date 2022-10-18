package a124.二叉树中的最大路径和;

/**
 * 思路：首先得到每个节点的路径最大贡献值，max（left,right,0）+cur.val
 * 再遍历一次，计算最大的路径和
 */
class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // 返回当前节点的最大路径贡献值
    int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 左右节点的组大路径贡献值
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        // 当前节点为根的最大路径和
        max=Math.max(max,left+right+root.val);
        return root.val+Math.max(left,right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(solution.maxPathSum(node1));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}