package 剑指Offer54.二叉搜索树的第k大节点;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * 递减的中序
 * 时间：O(n),当树退化成链表，栈深度为n
 * 空间:O(n),同上
 */
class Solution {
    int k=0,ans=0;
    public int kthLargest(TreeNode root, int k) {
        this.k=k;
        dfs(root);
        return ans;
    }
    void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.right);
        k--;
        if(0==k){
            ans=root.val;
            return;
        }
        dfs(root.left);
    }
}