package 二叉树遍历;

import java.util.LinkedList;

/**
 * https://blog.csdn.net/weixin_50813307/article/details/127035271
 */
public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;

        System.out.println("先序遍历递归：");
        dfs(nodeA);
        System.out.println("\n先序遍历非递归（栈）：");
        dfs2(nodeA);
        System.out.println("\n中序遍历非递归（栈）：");
        inOrder(nodeA);
        System.out.println("\n后序遍历非递归（两个栈）：");
        reserveOrder(nodeA);
        System.out.println("\n层序遍历（队列）：");
        bfs(nodeA);
    }

    /**
     * 先序非递归（栈）
     * @param head
     */
    static void dfs2(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(head);
        while (!stack.isEmpty()) {
            Node node = stack.removeLast();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
        }
    }

    /**
     * 先序递归
     *
     * @param head
     */
    static void dfs(Node head) {
        if (head != null) {
            System.out.print(head.val + " ");
            dfs(head.left);
            dfs(head.right);
        }
    }

    /**
     * 中序非递归
     * （先把左边界的所有节点入栈，然后弹出栈顶节点，
     * 若栈顶节点有右节点则将右节点的所有左边界节点入栈，再弹出，周而复始)
     */
    static void inOrder(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        while (head != null || !stack.isEmpty()) {
            if (head != null) {
                stack.addLast(head);
                head = head.left;
            } else { // Head=null说名左子树全部访问完了，开始转向右子树递归
                head = stack.removeLast();
                System.out.print(head.val+" ");
                head = head.right; // 右孩子递归
            }
        }
    }

    /**
     * 两个栈，辅助栈存储：根-左-右
     * @param head
     */
    static void reserveOrder(Node head){
        if(head==null){
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> res = new LinkedList<>();

        stack.addLast(head);
        while (!stack.isEmpty()){
            Node node = stack.removeLast();
            res.addLast(node);
            if(node.left!=null){
                stack.addLast(node.left);
            }
            if(node.right!=null){
                stack.addLast(node.right);
            }
        }
        while (!res.isEmpty()){
            System.out.print(res.removeLast().val+" ");
        }
    }

    /**
     * 层序遍历
     *
     * @param head
     */
    static void bfs(Node head) {
        if (head == null) {
            return;
        }
        LinkedList<Node> que = new LinkedList<>();
        que.addLast(head);
        while (!que.isEmpty()) {
//            for (int i = que.size(); i >= 1; i--) {
            Node node = que.removeFirst();
            System.out.print(node.val + " ");
            if (node.left != null) {
                que.addLast(node.left);
            }
            if (node.right != null) {
                que.addLast(node.right);
            }
//            }
        }
    }
}

class Node {
    public Node left;
    public Node right;

    String val;

    public Node(String val) {
        this.val = val;
    }

}
