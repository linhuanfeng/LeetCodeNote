package 剑指Offer26.树的子结构;


import java.util.LinkedList;
import java.util.Queue;

/**
 * ac但效率不高
 * 注意可以改进，对isSubStructure进行递归
 * 时间复杂度：O(MN) M,N分别为数A和树B的节点数量，先遍历树A，再遍历树B判断是不是子树
 * 空间复杂度：O(N) 队列得长度
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        Queue<TreeNode> que=new LinkedList<>();
        que.add(A);
        while (!que.isEmpty()){
            TreeNode root = que.poll();
            if(root==null){
                continue;
            }
            if(root.val==B.val){
                if(isSubTree(root,B)){
                    return true;
                }
            }
            que.offer(root.left);
            que.offer(root.right);
        }
        return false;
    }

    /**
     * 判断rootB是不是rootA的子树
     * @param rootA
     * @param rootB
     * @return
     */
    boolean isSubTree(TreeNode rootA,TreeNode rootB){
        if(rootB==null){
            // 子树为空 也是递归出口
            return true;
        }
        if(rootA==null||rootB.val!=rootA.val){
            return false;
        }
        return isSubTree(rootA.left,rootB.left)&&isSubTree(rootA.right,rootB.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(1);
        System.out.println(solution.isSubStructure(A, B));
    }
}
