package a221.最大正方形;

/**
 * 时间:O(mn min(m,n)^2) 遍历正方形n*m,每一个小正方形为min(n,m)^2
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]=='1')
                    ans=Math.max(ans,cal(matrix,i,j)); // 因为cal(..) 默认当前元素是1，即正方形个数至少为1
            }
        }
        return ans;
    }
    private int cal(char[][] matrix,int x,int y){
        int k=1;
        while (true){
            int i=x+k;
            if(i>=matrix.length)
                return k*k;
            for (int j = y; j<=y+k; j++) {
                if(j>=matrix[0].length||matrix[i][j]=='0'){
                    return k*k;
                }
            }
            i=y+k;
            for (int j = x; j<=x+k; j++) {
                if(j>=matrix.length||matrix[j][i]=='0'){
                    return k*k;
                }
            }
            k++;
        }
    }
}