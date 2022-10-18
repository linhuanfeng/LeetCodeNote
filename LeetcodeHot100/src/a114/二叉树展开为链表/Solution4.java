package a114.二叉树展开为链表;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 寻找当前结点的右孩子的前驱结点，当前结点的左子树最右边的结点即为当前结点的右孩子的前驱节点
 * 然后将当前结点的左子树的最右结点的右指针指向当前结点的右孩子
 * 把当前结点的左指针置空，并把当前结点的右指针指向当前结点的左指针
 * 时间：O(n) 每个结点遍历一次
 * 空间：O(1) 基本没有临时变量
 */
public class Solution4 {
    public void flatten(TreeNode root) {
        List<Integer> list=new ArrayList<>();
//        list.add()
        TreeNode cur=root;
        while (cur!=null){
            if(cur.left!=null){
                // 记录当前结点的左孩子
                TreeNode leftChild=cur.left;
                // 找当前结点右孩子的前驱结点
                TreeNode precursor=leftChild;
                while (precursor.right!=null){
                    precursor=precursor.right;
                }
                precursor.right=cur.right;
                cur.left=null;
                cur.right=leftChild;
            }
            cur=cur.right;
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
        Solution4 solution = new Solution4();
        solution.flatten(n1);
        while (n1!=null){
            System.out.print(n1.val+" ");
            n1=n1.right;
        }
    }
}