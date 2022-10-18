package a114.二叉树展开为链表;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用前序递归遍历，同时保存到一个list中
 */
public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list=new ArrayList<>();
        in(root,list);
        if(list.size()<=1){
            return;
        }
        for (TreeNode treeNode : list) {
            root.right=treeNode;
            root=treeNode;
            treeNode.left=null;
        }
    }
    void in(TreeNode root, List<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        in(root.left,list);
        in(root.right,list);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left=n2;
        n1.right=n5;
        n2.left=n3;
        n2.right=n4;
        n5.right=n6;
        Solution solution = new Solution();
        solution.flatten(n1);
        while (n1!=null){
            System.out.print(n1.val+" ");
            n1=n1.right;
        }
    }
}