package a114.二叉树展开为链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用前序迭代遍历，同时保存到一个list中
 * 时间：O(n) 每个结点遍历一次
 * 空间：O(N) 两个O(n)放前序遍历的数据
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        // 尽量使用一个新的node来指向root,防止一些不必要的麻烦
        List<TreeNode> list=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode node=root;
        while (node!=null||!stack.isEmpty()){
            while (node!=null){
                list.add(node);
                // addfirst
                stack.push(node);
                node=node.left;
            }
            // removeFirst
            node = stack.pop();
            node=node.right;
        }
        int len = list.size();
        // 元素可能只有一个,则循环不用进入,root为空也不能进入
        for (int i=1;i<len;i++) {
            TreeNode prev=list.get(i-1);
            TreeNode cur=list.get(i);
            prev.left=null;
            prev.right=cur;
            cur.right=null;
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
        solution.flatten(n1);
        while (n1!=null){
            System.out.print(n1.val+" ");
            n1=n1.right;
        }
    }
}