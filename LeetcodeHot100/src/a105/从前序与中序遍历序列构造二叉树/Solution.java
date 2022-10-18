package a105.从前序与中序遍历序列构造二叉树;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(preorder[0]);
        build(head,preorder,inorder,0,preorder.length-1,0);
        return head;
    }
    private void build(TreeNode root,int[] preorder,int[] inorder,int pre_left,int pre_right,int in_left){
        if(root==null)return;;
        int  count=0;
        // 从中序序列inorder确定左子树的个数
        while (inorder[in_left+count]!=root.val)count++; // 记录左子树个数
        if(count>0){
            // 说明左子树不为空
            root.left=new TreeNode(preorder[pre_left+1]); // 先序遍历头节点下一个就是就是左孩子
        }
        if(count!=pre_right-pre_left){
            // 左子树数目不等于左右子树个数，说明右子树不为空
            root.right=new TreeNode(preorder[pre_left+count+1]); // 右孩子最先被遍历
        }
        // 递归构建左右子树
        build(root.left,preorder,inorder,pre_left+1,pre_left+count,in_left);
        build(root.right,preorder,inorder,pre_left+count+1,pre_right,in_left+count+1);
    }
}