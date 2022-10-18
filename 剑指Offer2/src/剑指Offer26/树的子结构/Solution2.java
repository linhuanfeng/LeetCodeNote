package 剑指Offer26.树的子结构;


import java.util.LinkedList;
import java.util.Queue;

/**
 * ac但效率不高
 * 注意可以改进，对isSubStructure进行递归
 * 时间复杂度：O(MN) M,N分别为数A和树B的节点数量，先遍历树A，再遍历树B判断是不是子树
 * 空间复杂度：O(N) 队列得长度
 */
public class Solution2 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null||B!=null&&A==null){
            // 规定B为空不是A的左子树
            // B不为空但是A空了，则B肯定不是A的左子树
            return false;
        }
        // 如果当前树和B是子树结构，或左子树是和B，或右子树和B，都是2满足条件的，所以用|
        return isSubTree(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        // return (B!=null&&A!=null)isSubTree(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        // 因为B不可能为null,所以当A为null时，不是左子树
    }

    /**
     * 判断当前树
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
        Solution2 solution = new Solution2();
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(1);
        System.out.println(solution.isSubStructure(A, B));
    }
}
