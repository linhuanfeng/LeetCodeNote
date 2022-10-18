package a101.对称二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 采用双指针+递归的方式，用两个同步指针
  */

public class Solution2 {
  public boolean isSymmetric(TreeNode root) {
      return check(root.left,root.right);
  }
  boolean check(TreeNode node1,TreeNode node2){
      if(node1==null||node2==null){
          if(node1!=node2)return false;
          else return true;
      }
      return node1.val==node2.val&&check(node1.left,node2.right)&&check(node1.right,node2.left);
  }
}