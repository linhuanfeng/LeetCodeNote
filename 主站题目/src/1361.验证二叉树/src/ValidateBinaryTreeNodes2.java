import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidateBinaryTreeNodes2 {
    public static void main(String[] args) {
        int n=4;
        int[] leftChild={1,-1,3,-1};
        int[] rightChild={2,3,-1,-1};
        System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
    }
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // 遍历获取所有节点的出入度
        int[] in=new int[n];
        int[] out=new int[n];
        for (int i=0;i<n;i++){
            int lfChild=leftChild[i],rtChild=rightChild[i];
            if(lfChild!=-1){
                in[lfChild]++;
                out[i]++;
            }
            if(rtChild!=-1){
                in[rtChild]++;
                out[i]++;
            }
        }
        // 找到入度为0的根节点 注意这里可能有多个根结点，留到后面再排除
        int root=-1;
        for (int i =0;i<n;i++) {
            if(in[i]==0){
                root=i;
            }
        }
        // 遍历二叉树 每个节点都只能被访问一次
        // 这里采用前序遍历
        Set<Integer> hashSet=new HashSet<>();// 记录每个节点被访问的次数
        Stack<Integer> stack = new Stack<>();
        int node=root;
        while(node!=-1||!stack.isEmpty()){
            // 迭代访问左孩子并入栈
            while(node!=-1){
                if(hashSet.contains(node)){
                    return false;
                }
                hashSet.add(node);
                stack.push(node);
                node=leftChild[node];
            }
            // 如果节点没有左孩子，则弹出栈顶节点，把其右孩子入栈
            if(!stack.isEmpty()){
                // 节点右孩子
                node=stack.pop();
                node=rightChild[node];
            }
        }
        return hashSet.size()==n?true:false;
    }
}
