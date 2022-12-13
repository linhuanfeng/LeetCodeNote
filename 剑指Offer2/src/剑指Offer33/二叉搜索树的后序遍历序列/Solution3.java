package 剑指Offer33.二叉搜索树的后序遍历序列;

/**
 * 递归：
 * 二叉搜索数：左子树都小于等于根节点，右子树大于等于根节点
 * 后序遍历的特点：最后一个为根节点，对于【i，j】将从左到右遍历，找到第一个大于根节点的数下标m，
 *  以此分为左右子树,同时保证【m,j-1】的数都大于根节点
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 时间：nlogn 类似二分查找
 * 空间：nlogn 二分查找的递归深度
 */
public class Solution3 {
    public boolean verifyPostorder(int[] postorder) {
        return func(postorder,0, postorder.length-1);
    }
    boolean func(int[] postorder,int left,int right){
        if(left>=right){
            return true;
        }
        int m=right;
        for (int i = left; i <right ; i++) {
            if(postorder[i]>postorder[right]){
                // 找到第一个大于根节点的数，就是左右子树的分界线
                m=i;
                break;
            }
        }
        // 保证m右边的都大于根节点
        for (int i = m+1; i <right ; i++) {
            if(postorder[i]<postorder[right]){
                return false;
            }
        }
        // 左子树已经证明过都是小于根节点的
        return func(postorder, left, m-1)&&func(postorder, m, right-1);
    }
    public static void main(String[] args) {
        int[] postorder={1,3,2,6,5};
        Solution3 solution = new Solution3();
        System.out.println(solution.verifyPostorder(postorder));
    }
}
