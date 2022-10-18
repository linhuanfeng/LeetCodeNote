package a437.路径总和III;

class Solution {
    int ans = 0;

    public int pathSum(TreeNode root, int targetSum) {
        // 我先采用暴力遍历
        if (root != null) {
            dfs(root, targetSum - root.val);
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        return ans;
    }

    void dfs(TreeNode root, int targetSum) {
        if (targetSum == 0) {
            ans++;
        }
//        if (root == null) {
//            return;
//        }
        if (root.left != null) {
            dfs(root.left, targetSum - root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, targetSum - root.right.val);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(100);
        TreeNode n2 = new TreeNode(100);
        TreeNode n3 = new TreeNode(29);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
        Solution solution = new Solution();
        System.out.println(solution.pathSum(n1, 8));
    }
}
