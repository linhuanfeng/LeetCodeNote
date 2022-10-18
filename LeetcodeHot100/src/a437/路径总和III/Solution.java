package a437.路径总和III;

/**
 *  普通dfs
 *  时间：o(n^2)
 * 空间复杂度:栈的深度O(n)
 */
class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        inSort(root, targetSum);
        return ans;
    }
    void inSort(TreeNode node,int targetSum){
        if(node==null)return;
        dfs(node,node.val,targetSum);
        inSort(node.left,targetSum);
        inSort(node.right,targetSum);
    }
    void dfs(TreeNode root,int total,int targetSum){
        if(targetSum==total)
            ans++;
        if(root.left!=null)dfs(root.left,total+root.left.val,targetSum); // 记住是total+root.left.val，而不是root.val(重复计算)
        if(root.right!=null)dfs(root.right,total+root.right.val,targetSum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3,1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        TreeNode node3_ = new TreeNode(3,2);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        node10.left=node5;
        node10.right=node_3;
        node5.left=node3;
        node5.right=node2;
        node3.left=node3_;
        node3.right=node_2;
        node_3.right=node11;
        node2.right=node1;
        System.out.println(solution.pathSum(node10, 8));
    }
}