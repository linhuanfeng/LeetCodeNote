package 剑指Offer36.二叉搜索树与双向链表;

/**
 * 如何获取前驱结点
 * 中序遍历，得到当前结点和前驱结点，再修改指针指向即可
 */
class Solution2 {
    Node pre=null,head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        inOrder(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            if(pre==null){
                head=pre=root;
            }else {
                pre.right=root;
                root.left=pre;
                pre=root;
            }
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node4.left=node2;
        node4.right=node5;
        node2.left=node1;
        node2.right=node3;

        Node head = new Solution2().treeToDoublyList(node4);
    }
}
