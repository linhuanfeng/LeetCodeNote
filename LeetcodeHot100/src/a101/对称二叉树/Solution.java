package a101.对称二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 采用队列的方式，每次存放入队对称位置的结点
 * 时间：O(n)遍历所有结点
 * 空间：O(n)只有一个根节点的时候，放2*n和元素；当大于1个结点时，存放最多不超过n个结点
 */
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
  // 使用迭代的方式
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 队列运行添加null值吧
        Deque<TreeNode> que=new LinkedList<>();
        que.offer(root);
        que.offer(root);
        while (!que.isEmpty()){
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            // 不对称返回false
            if(left.val!=right.val)return false;
            // 如果有一个为空，则一定要都为空
            if(left.left==null||right.right==null){
                // 要么全为空，不然就不对称
                if(left.left!=right.right){
                    return false;
                }
            }else {
                que.offer(left.left);
                que.offer(right.right);
            }
            if(left.right==null||right.left==null){
                // 要么全为空，不然就不对称
                if(left.right!=right.left){
                    return false;
                }
            }else {
                que.offer(left.right);
                que.offer(right.left);
            }
        }
        return true;
    }
}