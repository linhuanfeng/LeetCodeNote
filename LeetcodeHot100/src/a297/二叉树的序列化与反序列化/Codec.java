package a297.二叉树的序列化与反序列化;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 可以采用二叉树的深度搜索解决
 * 我这里采用线序遍历
 * <p>
 * 时间：O(n) 每个节点都只遍历一次
 * 空间：O(n)递归的深度
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public String rSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "none,";
        } else {
            str += root.val + ",";
            str = rSerialize(root.left, str); // 注意str=指向新的，因为java是值传递并且str具有不可变性
            str = rSerialize(root.right, str);
        }
        return str;
    }
//    public String rSerialize2(TreeNode root, StringBuilder sb) {
//        if (root == null) {
//            sb.append(",none");
//        } else {
//            sb.append("," + root.val);
//            rSerialize2(root.left, sb);
//            rSerialize2(root.right, sb);
//        }
//        return sb.toString();
//    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(",")));
        return rDeserialize(list);
    }

    public TreeNode rDeserialize(List<String> list) {
        if (list.get(0).equals("none")) { // 不需要判断list是否为空，因为每个元素都会被访问一次，存多少就刚好访问多少
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = rDeserialize(list);
        node.right = rDeserialize(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;

        Codec codec = new Codec();
        String serialize = codec.serialize(node1);
        System.out.println(serialize); // 1,2,3,none,none,4,none,none,5,none,none, 最后的“”不会被保存

        TreeNode deserialize = codec.deserialize(serialize);
        String serialize2 = codec.serialize(node1);
        System.out.println(serialize2); // 1,2,3,none,none,4,none,none,5,none,none,
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));