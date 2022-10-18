package 剑指Offer66.构建乘积数组;

/**
 * 时间：O(n) 两个for循环，为O(N)
 * 空间：O(1) 常数级
 */
class Solution {
    public int[] constructArr(int[] a) {
        if(a==null||a.length==0){
            return new int[0];
        }
        int[] B=new int[a.length];
        B[0]=1;
        for (int i = 1; i < a.length; i++) {
            B[i]=a[i-1]*B[i-1];
        }
        int tmp=1; //前一次右三角的乘机
        for (int i = a.length-2; i >=0; i--) {
            B[i]=B[i]*a[i+1]*tmp;
            tmp=tmp*a[i+1];
        }
        return B;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a={7, 2, 2, 4, 2, 1, 8, 8, 9, 6, 8, 9, 6, 3, 2, 1};
        int[] ints = solution.constructArr(a);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}