package a538.把二叉搜索树转换为累加树;

/**
 * 方法二：Morris 遍历
 * 有一种巧妙的方法可以在线性时间内，只占用常数空间来实现中序遍历。这种方法由 J. H. Morris 在 1979 年的论文「Traversing Binary Trees Simply and Cheaply」中首次提出，因此被称为 Morris 遍历。
 * Morris 遍历的核心思想是利用树的大量空闲指针，实现空间开销的极限缩减。其反序中序遍历规则总结如下：
 * 如果当前节点的右子节点为空，处理当前节点，并遍历当前节点的左子节点；
 * 如果当前节点的右子节点不为空，找到当前节点右子树的最左节点（该节点为当前节点中序遍历的前驱节点）；
 * 如果最左节点的左指针为空，将最左节点的左指针指向当前节点，遍历当前节点的右子节点；
 * 如果最左节点的左指针不为空，将最左节点的左指针重新置为空（恢复树的原状），处理当前节点，并将当前节点置为其左节点；
 * 重复步骤 1 和步骤 2，直到遍历结束。
 * 这样我们利用 Morris 遍历的方法，反序中序遍历该二叉搜索树，即可实现线性时间与常数空间的遍历。
 *
 * 利用线索二叉树的思想和反中序遍历
 *
 * 右子树都比当前结点先处理
 *
 * 如果当前结点的右孩子为空，说明当前可以轮到当前结点处理了，并转到左孩子
 * 如果当前结点的右孩子不为空：
 *      如果右子树的最左结点（当前结点反中序遍历的前驱结点）等于空，将其左指针指向当前结点，转向右孩子
 *      如果右子树的最左结点等于当前结点，那么说明已经处理过了，将其左指针置为空，说明右子树都处理完了，处理当前并转到左孩子
 */
public class Solution2 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        TreeNode node=root;
        while (node!=null){
            if(node.right==null){
                // 可以处理当前结点了
                sum+=node.val;
                node.val=sum;
                node=node.left;
            }else {
                TreeNode qianQu = getQianQu(node);
                if(qianQu.left==null){
                    qianQu.left=node; // 将右子树最左结点指向当前结点，当后面重新遍历到当前结点时，说明左子树都遍历完了
                    node=node.right;
                }else {
                    // 右子树最左结点的不为空，说明右子树都已遍历完过了，可以处理当前结点了
                    qianQu.left=null;
                    sum+=node.val;
                    node.val=sum;
                    node=node.left;
                }
            }
        }
        return root;
    }
    // 获取当前结点右子树的最左结点，默认当前结点右孩子不为空
    private TreeNode getQianQu(TreeNode root){
        TreeNode right=root.right;
        while (right.left!=null&&right.left!=root){
            right=right.left;
        }
        return right;
    }
}
