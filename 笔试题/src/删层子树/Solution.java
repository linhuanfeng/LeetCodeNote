package 删层子树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param root TreeNode类 
     * @param a int整型ArrayList 
     * @return TreeNode类ArrayList
     */
    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {
        // write code here
        Deque<TreeNode> que=new LinkedList<>();
        que.add(root);
        int level=1;
        TreeNode newRoot=null;
        boolean first=true;
        boolean beginNew=true;
        ArrayList<TreeNode> container=new ArrayList<>();
        while (!que.isEmpty()){
            int size=que.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = que.poll();
                if(poll.left!=null)que.offer(poll.left);
                if(poll.right!=null)que.offer(poll.right);
                boolean key=false;
                for (Integer integer : a) {
                    if(level==integer.intValue()){
                        poll.val=0;
                        key=true;
                        break;
                    }
                }
                TreeNode last = container.get(container.size() - 1);
//                last.right
                container.add(new TreeNode(poll.val));
            }
            level++;
        }

        return null;
    }
}