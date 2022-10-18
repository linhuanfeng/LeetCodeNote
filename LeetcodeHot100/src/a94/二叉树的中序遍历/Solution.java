package a94.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode node=root;
        List<Integer> list=new ArrayList<>();
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node=node.right;
        }
        return list;
    }
}