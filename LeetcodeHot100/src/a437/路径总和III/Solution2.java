package a437.路径总和III;

import java.util.HashMap;
import java.util.Map;

/** * 前缀和+回溯
 * map[prefix,count]保存根节点到当前结点之前所有的前缀和对应的个数，cur表示当前结点的值，
 * 判断是否存在前缀和为val-target的结点j,设当前结点为i，j<i,那么j->i就是目标路径 因为prefix[i]-prefix[j]=target
 *
 *  时间：o(n)
 * 空间:O(n) 存放临时结点
 */
class Solution2 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        Map<Long,Integer> prefix=new HashMap<>(); // 注意前缀和可能整形溢出
        prefix.put(0L,1);
        return dfs(root,prefix, (long) root.val,targetSum);
    }
    int dfs(TreeNode root, Map<Long,Integer> prefix ,Long cur, int targetSum){
        if(root==null)
            return 0;
        int res=0;
        if(prefix.containsKey(cur-targetSum)){ // 判断以当前结点之前是否有符合条件的前缀和
            res+=prefix.get(cur-targetSum);
        }
        prefix.put(cur,prefix.getOrDefault(cur,0)+1); // 放入当前的前缀和
        if(root.left!=null)res+=dfs(root.left,prefix,cur+root.left.val,targetSum); // 记住是root.left.val，而不是root.val(重复计算)
        if(root.right!=null)res+=dfs(root.right,prefix,cur+root.right.val,targetSum);
        prefix.put(cur,prefix.getOrDefault(cur,1)-1); // 回溯之后当前值就不在前缀和中了
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node_3 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3,1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node11 = new TreeNode(11);
        TreeNode node3_ = new TreeNode(3,2);
        TreeNode node_2 = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        node10.left=node5;
        node10.right=node_3;
        node5.left=node3;
        node5.right=node2;
        node3.left=node3_;
        node3.right=node_2;
        node_3.right=node11;
        node2.right=node1;
        System.out.println(solution.pathSum(node10, 8));
    }
}