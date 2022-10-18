package 异或传递;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回值的树节点中val表示节点权值
     * @param root TreeNode类 给定的初始树节点中的val表示节点编号
     * @param op int整型ArrayList<ArrayList<>> op的组成为[[id,v],[id,v],[id,v],...]
     * @return TreeNode类
     */
    public TreeNode xorTree (TreeNode root, ArrayList<ArrayList<Integer>> op) {
        // write code here
        initSort(root);
        for (ArrayList<Integer> integers : op) {
            Integer idx = integers.get(0);
            Integer v = integers.get(1);
//            this.idx=idx;
            doxor(idx_node.get(idx),v);
        }
        return root;
    }
//    TreeNode target=null;
//    int idx=1;
    Map<TreeNode,Integer> node_idx=new HashMap<>();
    Map<Integer,TreeNode> idx_node=new HashMap<>();
    /**
     * 初始值表示结点编号，
     *
      */
    void initSort(TreeNode root){
        if(root==null)return;
        node_idx.put(root,root.val);
        idx_node.put(root.val,root);
        root.val=0;
        initSort(root.left);
        initSort(root.right);
    }
//    void inSort(TreeNode root){
//        if(root==null)return;
//        if(root.val==idx){
//            target=root;
//        }
//        inSort(root.left);
//        inSort(root.right);
//    }
    void doxor(TreeNode root,int v){
        if(root==null)return;
        root.val=root.val^v;
        doxor(root.left,v);
        doxor(root.right,v);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        Solution solution = new Solution();
//        solution.inSort(node1);
//        System.out.println(solution.target.val);
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        ArrayList<Integer> integers2 = new ArrayList<>();
        integers1.add(2);
        integers1.add(4);
        integers2.add(1);
        integers2.add(2);
        lists.add(integers1);
        lists.add(integers2);
        TreeNode ans = solution.xorTree(node1, lists);
        System.out.println(ans.val);
        System.out.println(ans.left.val);
        System.out.println(ans.right.val);
    }
}