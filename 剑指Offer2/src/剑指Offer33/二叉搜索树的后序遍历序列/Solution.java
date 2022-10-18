package 剑指Offer33.二叉搜索树的后序遍历序列;

/**
 * 错误解法，比如遇到{4, 6, 12, 8, 16, 14, 10}就错了
 * 因为没有判断：当前节点小于其左子树的所有制，大于其右子树的所有节点
 */
@Deprecated
public class Solution {
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
        while (index<right&&postorder[index]<root){
            // 找到左右子树的分界点
            index++;
        }
//        if(index==left){
//            // 说明当前root树左子树为空，满足bst
//        }
        if(index-1>=left&&postorder[index-1]>root){
            // ps[index-1] 为左子树跟
            return false;
        }
        if(right-1>=index&&postorder[right-1]<root){
            // ps[right-1] 为右子树（若存在）的跟
            return false;
        }
        return isBST(postorder, left, index-1)&&isBST(postorder, index, right-1);
    }

    public static void main(String[] args) {
        int[] postorder={4, 6, 12, 8, 16, 14, 10};
        Solution solution = new Solution();
        System.out.println(solution.verifyPostorder(postorder));
    }
}
