/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
// */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InsertBST {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){return new TreeNode(val);}
        TreeNode res=root;
        TreeNode pre=null;
        while(res!=null){
            pre=res;
            if(res.val>val){
                res=res.left;
            }else{
                res=res.right;
            }
        }
        if(pre.val>val){
            pre.left=new TreeNode(val);
        }else{
            pre.right=new TreeNode(val);
        }
        return root;
    }
}
