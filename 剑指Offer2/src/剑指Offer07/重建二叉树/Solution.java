package 剑指Offer07.重建二叉树;

import java.util.HashMap;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * 时间复杂度：为数的节点个数O(n)
 * 空间复杂度：为额外存储树节点值与下标的映射hashMap O(n)
 * 算法思路：先序遍历的第一位就是根节点root
 *  接着在根节点中找到对应的根节点，则左边元素都是左子树，右边都是右子树
 *  接着递归获取 每次从先序第一位找到根节点，再在中序中找到对应的根节点
 *  中序的值与下标映射用hashMap是实现，提高时间效率
 */
public class Solution {
    // key表示节点值，value表示中序遍历中的下标
    Map<Integer,Integer> indexMap=new HashMap<>();

    /**
     *
     * @param preOrder 先序遍历序列
     * @param inOrder  中序遍历序列
     * @param preOrder_left 先序遍历中调用者的左子树的边界
     * @param preOrder_right 先序遍历中右子树的边界
     * @param inOrder_left 中序遍历中左子树的边界
     * @param inOrder_right 中序遍历中左子树的边界
     * @return
     */
    public TreeNode preOrder_inOrder(int[] preOrder, int[] inOrder,int preOrder_left,int preOrder_right,int inOrder_left,int inOrder_right){
        if(preOrder_left>preOrder_right){
            // 树的左右边界，说明数为空，返回null
            return null;
        }
        // 每次就返回根节点
        // 先序遍历的首元素就是根节点
        int pre_root_val=preOrder[preOrder_left];
        // 找到中序中根节点位置
        int in_root_index=indexMap.get(pre_root_val);
        // 中序中根节点左边为左子树，右边为右子树
        int left_sub_size=in_root_index-inOrder_left;
        // 先构建根节点
        TreeNode root = new TreeNode(pre_root_val);
        root.left=preOrder_inOrder(preOrder,inOrder,preOrder_left+1,preOrder_left+left_sub_size,inOrder_left,in_root_index-1);
        root.right=preOrder_inOrder(preOrder,inOrder,preOrder_left+left_sub_size+1,preOrder_right,in_root_index+1,inOrder_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return preOrder_inOrder(preorder,inorder,0,n-1,0,n-1);
    }

    public static void main(String[] args) {
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        Solution solution = new Solution();
        System.out.println(solution.buildTree(preorder, inorder));
    }
}
