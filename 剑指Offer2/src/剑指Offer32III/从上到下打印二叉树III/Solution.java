package 剑指Offer32III.从上到下打印二叉树III;


import java.util.*;

/**
 * 时间复杂度：O(N)每个结点访问一次，双端队列的队尾和队首操作时间复杂度都是O（1）
 * 空间复杂度：O(N)临时存放树的结点,双端队列que的花销
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            // 因为好像队列的可以插入null
            return res;
        }

        // 双端队列
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            LinkedList<Integer> temp=new LinkedList<>();
            for (int i = que.size(); i >0; i--) {
                // 当前层的结点个数,
                TreeNode node = que.poll();
                if((res.size()&1)==0){
                    // 奇数尾插
                    temp.addLast(node.val);
                }else {
                    temp.addFirst(node.val);
                }
                // 插入下一层
                if(node.left!=null){
                    que.add(node.left);
                }
                if(node.right!=null){
                    que.add(node.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
