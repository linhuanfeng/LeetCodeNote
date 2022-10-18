package a98.验证二叉搜索树;

/**
 * 直接中序遍历，pre指针记录前一个结点
 */
class Solution1 {
    TreeNode pre=null;
    boolean ans=true;
    public boolean isValidBST(TreeNode root) {
        inSort(root);
        return ans;
    }
    private void inSort(TreeNode root){
        if(root==null)return;
        inSort(root.left);
        if(pre==null)pre=root;
        else {
            if(root.val<=pre.val){
                ans=false;
                return;
            }
            pre=root;
        }
        inSort(root.right);
    }

    public static void main(String[] args) {

    }
}





