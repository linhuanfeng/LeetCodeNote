package 剑指Offer36.二叉搜索树与双向链表;

import java.util.Scanner;

/**
 * 时间：都遍历一次o(n)
 * 空间：栈的深度，退化成链表则为o(n)
 */
class Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }
    // 中序遍历完后返回
    void dfs(Node cur){
        if(cur==null){
            return;
        }
        // pre用于记录当前节点的左节点，当pre==null时，说明当前节点时首结点
        dfs(cur.left);
        // 第一次执行到这里的一定是首结点
        if(pre==null){
            //中序遍历的第一个叶子节点为最小，即链表的头节点
            head=cur;
        }else {
            pre.right=cur;
        }
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }

    public static void main(String[] args) {
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        node4.left=node2;
        node4.right=node5;
        node2.left=node1;
        node2.right=node3;
        Solution solution = new Solution();
        Node head = solution.treeToDoublyList(node4);
        for (int i = 0; i < 5; i++) {
            System.out.print(head.val+" ");
            head=head.right;
        }
    }

}