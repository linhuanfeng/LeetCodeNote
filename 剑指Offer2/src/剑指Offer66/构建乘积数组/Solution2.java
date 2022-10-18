package 剑指Offer66.构建乘积数组;

/**
 * 构建表格
 * 2 3
 * 3 2
 *
 *   0 1
 *   2 3
 * 2
 * 3   6
 *
 *    2   3   4
 * 2  0
 * 3      2
 * 4          8
 *
 *     0  1  2   3   4
 *     1  2  3   4   5
 * 0 1 * 120
 * 1 2 1  *  60
 * 2 3    2  *  20
 * 3 4       6   *   5
 * 4 5           24  *
 *
 * 时间：O(n)
 * 空间：O(m)
 *
 */
public class Solution2 {
    public int[] constructArr(int[] a) {
        if(a==null||a.length==0){
            return new int[0];
        }
        int n=a.length;
        int[] res=new int[n];

        res[0]=1;
        for (int i = 1; i <n ; i++) {
            res[i]=res[i-1]*a[i-1];
        }

        int right=1;
        for (int i = n-2; i >=0 ; i--) {
            res[i]*=a[i+1]*right;
            right*=a[i+1];
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : new Solution2().constructArr(new int[]{1,2,3,4,5})) {
            System.out.print(i+" ");
        }
    }
}
