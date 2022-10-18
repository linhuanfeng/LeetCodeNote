package a337.打家劫舍III;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目简化：父子结点不能同时取，得到最大的权值
 * 思路：一个结点T取得到的权值记作f(T)，不取记作g(T);
 *      左孩子取和不取分别记作f(l)和g(l),
 *      有孩子取何不去分别记作f(r)和g(r);
 * 当前结点的最大值
 *      若取了，左右孩子都不能取，即等于g(l)+g(r)
 *      若没取，左右孩子可取可不取，等于max(f(l),g(l))+max(f(r),g(r))
 * 使用中序遍历初始化所有的值
 * 动态规划，
 * 时间：
 */
class Solution {
    Map<TreeNode,Integer> rob;
    Map<TreeNode,Integer> unRob;
    public int rob(TreeNode root) {
        rob=new HashMap<>();
        unRob=new HashMap<>();
        postSort(root);
        return Math.max(rob.get(root),unRob.get(root));
    }
    void postSort(TreeNode root){
        if(root==null){
            return;
        }
        postSort(root.left);
        postSort(root.right);
        // 左右孩子不取之和
        rob.put(root,
                root.val+unRob.getOrDefault(root.left,0)+unRob.getOrDefault(root.right,0));
        // 左孩子取或不取的最大值加上右孩子取或不取的最大值
        unRob.put(root,
                Math.max(rob.getOrDefault(root.left,0),unRob.getOrDefault(root.left,0))+
                Math.max(rob.getOrDefault(root.right,0),unRob.getOrDefault(root.right,0)));
//        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(3);
        TreeNode root2=new TreeNode(4);
        TreeNode root3=new TreeNode(5);
        TreeNode root4=new TreeNode(1);
        TreeNode root5=new TreeNode(3);
        TreeNode root6=new TreeNode(1);
        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.right=root6;
        Solution solution = new Solution();
        System.out.println(solution.rob(root1));
    }
}