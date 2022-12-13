package bst第k大元素;

class Main {

    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        midIter(root);
        return res.val;
    }
    int k=0;
    TreeNode res;
    void  midIter(TreeNode root){
        if(root!=null){
            midIter(root.left);
            if(--k==0){
                res=root;
            }
//            System.out.print(k++);
//            System.out.println(" "+root.val);
            midIter(root.right);
        }
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode();
        node1.val=1;
        TreeNode node2 = new TreeNode();
        node2.val=2;
        TreeNode node3 = new TreeNode();
        node3.val=3;
        TreeNode node4 = new TreeNode();
        node4.val=4;

        node3.left=node1;
        node3.right=node4;
        node1.right=node2;
        System.out.println(new Main().kthSmallest(node3, 3));

//        Scanner scanner = new Scanner(System.in);
//        String inputStr = scanner.nextLine();
//        String pStr = scanner.nextLine();
//        String arrayStr = inputStr.substring(1, inputStr.lastIndexOf("]"));
//        String[] arrayStrArray = arrayStr.split(",");
//        Integer[] array = new Integer[arrayStrArray.length];
//        for (int i = 0; i < arrayStrArray.length; i++) {
//            if ("null".equals(arrayStrArray[i])) {
//                continue;
//            }
//            array[i] = Integer.valueOf(arrayStrArray[i]);
//        }
//
//        TreeNode root = createTree(0, array);
//        System.out.println(new Main().kthSmallest(root, Integer.parseInt(pStr)));
    }

    static TreeNode createTree(int rootIndex, Integer[] values) {
        if (rootIndex >= values.length) {
            return null;
        }
        if (values[rootIndex] == null) {
            return null;
        }
        TreeNode rootNode = new TreeNode();
        rootNode.val = values[rootIndex];
        rootNode.left = createTree(2 * rootIndex + 1, values);
        rootNode.right = createTree(2 * rootIndex + 2, values);
        return rootNode;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}