package a538.把二叉搜索树转换为累加树;

/**
 * 时间复杂度：O(n)每个结点都遍历一遍
 * 空间：O(n)，递归的深度，当树退化成链表，递归n次
 */
class Solution {
    // 反中序遍历，preVal记录前驱结点的值，preSum记录前缀和
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)return null;
        convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }
    void midSort(TreeNode root){
        if(root==null)return;
        midSort(root.left);
        System.out.println(root.val);
        midSort(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node4.left=node1;
        node4.right=node6;
        node1.left=node0;
        node1.right=node2;
        node2.right=node3;
        node6.left=node5;
        node6.right=node7;
        node7.right=node8;
        solution.convertBST(node4);
        solution.midSort(node4);
    }
}