package 二叉树最后层最左结点;

import java.util.*;

   class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
  }

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @return int整型
     */
    public int findBottomLeftValue (TreeNode root) {
        // write code here
        Deque<TreeNode> que=new LinkedList<>();
        TreeNode node=root;
        que.addLast(node);
        int res=-1;
        while (!que.isEmpty()){
            res=que.getFirst().val;
            for (int i = que.size(); i >0 ; i--) {
                TreeNode t = que.removeFirst();
                if(t.left!=null){
                    que.addLast(t.left);
                }
                if(t.right!=null){
                    que.addLast(t.right);
                }
            }
        }
        return res;
    }
}