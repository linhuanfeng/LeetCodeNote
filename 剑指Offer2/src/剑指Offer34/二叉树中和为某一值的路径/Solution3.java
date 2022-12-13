package 剑指Offer34.二叉树中和为某一值的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * 考虑用先序遍历
 *  从根节点到叶子节点 路径总和等于给定目标和的路径。
 *  注意是从根节点开始，叶子结点结束的路径
 *
 * 时间：n^n n个结点遍历一次*再找各自的路径
 * 空间：n^n 递归深度，n个结点遍历一次*再找各自的路径
 */
public class Solution3 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root!=null){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            preOrder(root,target-root.val,list);
        }
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    void preOrder(TreeNode root,int target,List<Integer> tempList){
        if(root!=null){
            if(target==0&&root.left==null&&root.right==null){
                res.add(new ArrayList<>(tempList));
            }
            if(root.left!=null){
                tempList.add(root.left.val);
                preOrder(root.left,target-root.left.val,tempList);
                tempList.remove(tempList.size()-1);
            }
            if(root.right!=null){
                tempList.add(root.right.val);
                preOrder(root.right,target-root.right.val,tempList);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        // 5,4,8,11,null,13,4,7,2,null,null,5,1
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left=node2;
        List<List<Integer>> sum = new Solution3().pathSum(node1, 1);

    }
}
