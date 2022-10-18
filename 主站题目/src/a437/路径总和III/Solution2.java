package a437.路径总和III;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用前缀和减少重复计算
 * 保留根节点到当前结点的所有前缀和，当前结点为curPrefix,判断前缀和中是否有curPrefix-targetSum,即为要找的路径
 * 注意回溯的时候把当前结点的前缀和减掉
 *
 * 时间：O(n)每个结点遍历遍
 * 空间：O(n)map存储前缀和
 */
class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        Map<Long,Integer> prefix=new HashMap<>(); // 记录根结点到当前路径所有结点的前缀和
        prefix.put(0l,1);
        // 我先采用暴力遍历
        return dfs(root, root.val,targetSum ,prefix);
    }

    // cur:根节点到当前结点的路径和
    int dfs(TreeNode root,long curPrefix,int targetSum,Map<Long,Integer> prefix) {
        if (root==null) {
            return 0;
        }

        // 判断是否有前缀和j等于curPrefix-target,那么j+1到当前结点就是目标路径
        Integer ret = prefix.getOrDefault(curPrefix - targetSum, 0);
        prefix.put(curPrefix,prefix.getOrDefault(curPrefix,0)+1);

        if(root.left!=null){
            ret+=dfs(root.left,curPrefix+root.left.val,targetSum,prefix);
        }

        if(root.right!=null){
            ret+=dfs(root.right,curPrefix+root.right.val,targetSum,prefix);
        }

        prefix.put(curPrefix,prefix.getOrDefault(curPrefix,1)-1); // 回溯的时候减去当前结点对应的前缀和
        return ret;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(11);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-2);
        TreeNode n9 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n4.left = n7;
        n4.right = n8;
        n5.right = n9;
        Solution2 solution = new Solution2();
        System.out.println(solution.pathSum(n1, 8));
    }
}
