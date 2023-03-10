package a59.螺旋矩阵II;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans=new int[n][n];
        int r=0,index=1;
        while (true) {
            for (int j = r; j <n-r ; j++) {
                ans[r][j]=index++;
            }
            for (int i = r+1; i < n-r; i++) {
                ans[i][n-r-1]=index++;
            }
            for (int j = n-r-2; j >=r ; j--) {
                ans[n-r-1][j]=index++;
            }
            for (int i = n-r-2; i >r ; i--) {
                ans[i][r]=index++;
            }
            if(index>n*n)return ans;
            r++;
        }
    }

    public static void main(String[] args) {
        int[][] ints = new Solution().generateMatrix(4);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
