package a114.二叉树展开为链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 记录前一个结点，让前一个结点指向当前结点
 * 时间：O(n) 每个结点遍历一次
 * 空间：O(N) 取决去栈的大小，不会超过O(n)
 */
public class Solution3 {
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        // 尽量使用一个新的node来指向root,防止一些不必要的麻烦
//        List<TreeNode> list=new ArrayList<>();
        TreeNode pre=new TreeNode();
        Deque<TreeNode> stack=new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            pre.left=null;
            pre.right=cur;
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
            pre=cur;
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
        Solution3 solution = new Solution3();
        solution.flatten(n1);
        while (n1!=null){
            System.out.print(n1.val+" ");
            n1=n1.right;
        }
    }
}