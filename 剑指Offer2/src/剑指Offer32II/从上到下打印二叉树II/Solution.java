package 剑指Offer32II.从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class  TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

/**
 * 特例处理： 当根节点为空，则返回空列表 [] ；
 * 初始化： 打印结果列表 res = [] ，包含根节点的队列 queue = [root] ；
 * BFS 循环： 当队列 queue 为空时跳出；
 *      新建一个临时列表 tmp ，用于存储当前层打印结果；
 *      当前层打印循环： 循环次数为当前层节点数（即队列 queue 长度）；
 *      出队： 队首元素出队，记为 node；
 *      打印： 将 node.val 添加至 tmp 尾部；
 *      添加子节点： 若 node 的左（右）子节点不为空，则将左（右）子节点加入队列 queue ；
 *      将当前层结果 tmp 添加入 res 。
 * 返回值： 返回打印结果列表 res 即可。
 */

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ans =new ArrayList<>();
        while (!queue.isEmpty()){
            // 当前队列的长度即为当前层的结点个数
            List<Integer> list=new ArrayList<>();
            for (int i = queue.size(); i >=1 ; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}