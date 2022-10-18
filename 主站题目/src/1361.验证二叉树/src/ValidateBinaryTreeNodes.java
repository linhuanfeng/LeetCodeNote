/**
 * 虽然leetcode上通过了，但是由于测试用例比较少，所以可能算法还是错的
 */
public class ValidateBinaryTreeNodes {
    public static void main(String[] args) {
        int n=4;
        int[] leftChild={1,2,0,-1};
        int[] rightChild={-1,-1,-1,-1};
        System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
    }
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if(n==1){
            return true;
        }
        int[] hasPrev=new int[n];// 下标表示当前节点，值表示前驱节点
        for (int i =0;i<hasPrev.length; i++) {
            hasPrev[i]=-1;
        }
        for (int i = 0; i < n; i++) {
            int lf=leftChild[i],rt=rightChild[i];
            if(lf!=-1){// 左节点不为空
                // 进来说明找到左孩子的前驱节点了
                if(hasPrev[lf]!=-1){// 如果已经有前驱节点，则报错
                    return false;
                }
                hasPrev[lf]=i;
            }
            if(rt!=-1){
                // 进来说明找到右孩子的前驱节点了
                if(hasPrev[rt]!=-1){// 如果已经有前驱节点，则报错
                    return false;
                }
                hasPrev[rt]=i;
            }
        }
        int root=0;
        for (int i =0;i<hasPrev.length; i++) {
            int pre=hasPrev[i];
            if(root>1){// 必须只有一个根节点
                return false;
            }
            if(pre!=-1&&hasPrev[pre]==i){// 互为前驱结点
                return false;
            }else if(pre==-1){// 根节点
                boolean key=false;
                for(int k=0;k<hasPrev.length;k++){
                    if(hasPrev[k]==i){
                        key=true;
                    }
                }
                if(!key){
                    return false;
                }
                root++;
            }
        }
        return root==1?true:false;
    }
}
