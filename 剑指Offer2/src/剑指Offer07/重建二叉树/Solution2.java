package 剑指Offer07.重建二叉树;

/**
 * 根据前序获取当前根节点，把中序分为左右子树序列，根据左右子树序列反推前序遍历的左右子树序列
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0, preorder.length-1, inorder,0, inorder.length-1);
    }

    /**
     *
     * @param preorder
     * @param left1 前序遍历的左边界下标
     * @param right1 中序遍历的右边界下标
     * @param inorder
     * @param left2
     * @param right2
     */
    public TreeNode build(int[] preorder, int left1,int right1,int[] inorder,int left2,int right2){
        if(left1>right1){
            return null;
        }
        TreeNode head = new TreeNode(preorder[left1]);
        // 找出根结点在中序的下标
        int k=-1; // 根节点在中序遍历的下标
        for (int i = left2; i <=right2 ; i++) {
            if(inorder[i]==head.val){
                k=i;
                break;
            }
        }
        // k-left2为左子树的结点个数
        head.left=build(preorder, left1+1, left1+(k-left2), inorder, left2, k-1);
        head.right=build(preorder, left1+(k-left2)+1, right1, inorder, k+1,right2);
        return head;
    }
}
