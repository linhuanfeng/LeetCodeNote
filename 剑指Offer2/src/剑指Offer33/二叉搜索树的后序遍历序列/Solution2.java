package 剑指Offer33.二叉搜索树的后序遍历序列;

/**
 * 循环递归，当前节点大于其左子树的所有值，小于其右子树的所有节点
 * 时间复杂度：O（n2） 递归深度为n,当bst退化成链表的时候，每次都要遍历所有的节点
 * 空间复杂度：O(N)最坏的情况，退化成链表，栈的深度
 */
public class Solution2 {
    public boolean verifyPostorder(int[] postorder) {
        return isBST(postorder,0,postorder.length-1);
    }
    boolean isBST(int[] postorder,int left,int right){
        if(left>=right){
            // 一个节点必然是bst
            return true;
        }
        int root=postorder[right];
        int index=left;
        while (postorder[index]<root){
            // 找到第一个大于根节点的下标，左右子树的分界点
            index++;
        }
        int m=index;  // m为左右子树的分界点
        while (postorder[index]>root){
            // 此时m~right都是右子树的内容，所有都要大于等于根节点（等于因为它就是根节点）
            index++;
        }
        return index==right&&isBST(postorder, left, m-1)&&isBST(postorder, m, right-1);
    }

    public static void main(String[] args) {
        int[] postorder={4, 6, 12, 8, 16, 14, 10};
        Solution2 solution = new Solution2();
        System.out.println(solution.verifyPostorder(postorder));
    }
}
