package a437.路径总和III;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      int tag=-1;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public TreeNode(int val,  int tag) {
        this.val = val;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "node.val="+ val+",tag="+tag;
    }
}