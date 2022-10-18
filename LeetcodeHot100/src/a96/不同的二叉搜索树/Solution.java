package a96.不同的二叉搜索树;

/**
 * 动态规划：
 * 给定序列：1，2，3...n，我们可以遍历每一个i作为根节点,
 * 根据i分为两个子序列[1,i-1],[i+1,n]进行递归，所以可以用动态规划来解决
 * <p>
 * 使用G(i)表示长度为i的序列的二叉搜索树个数，（1，2，3和5，6，7是一样的，只跟个数有关，跟位置无关）
 * 使用f(i,n)表示根节点是i长度，长度为n的序列的搜索树个数
 * 因此，G(n)=f(i,n) i=1.n累加  ①，边界条件：G(0)=1 G(1)=1
 * <p>
 * 选定数字i，f(i,n)=左右子树的搜索树个数的笛卡尔积，即f(i,n)=G(i-1)*G(n-i) ②
 * <p>
 * 联立①和②，得G(n)=G(i-1)*G(n-i) i=1.n累加
 * <p>
 * 时间：O(n^2)
 * 空间：O(n)
 */
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0]=G[1]=1;
        /**
         * g[1]=g[0]*g[0]
         * g[2]=g[0]*g[1]+g[1]*g[0]
         * g[3]=g[0]*g[2]+g[1]*g[1]+g[2]*g[0]
          */
        for (int i = 2; i <= n; i++) { // n 注意从2开始
            for (int j = 1; j <=i ; j++) { // i从1累加到n
                G[i]+=G[j-1]*G[i-j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}