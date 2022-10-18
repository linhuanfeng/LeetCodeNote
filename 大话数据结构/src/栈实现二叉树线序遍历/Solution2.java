package 栈实现二叉树线序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用前序非递归遍历，同时保存到一个list中
 */
public class Solution2 {
    void in(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            TreeNode left = node.left;
            TreeNode right = node.right;
            if(right!=null){
                stack.push(right);
            }
            if(left!=null){
                stack.push(left);
            }
        }
    }
    void in2(TreeNode root){
        if(root==null){
            return;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                System.out.print(root.val+" ");
                stack.add(root);
                root=root.left;
            }
            TreeNode pop = stack.pop();
            root=pop.right;
        }
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
        Solution2 solution = new Solution2();
        solution.in(n1);
    }
}