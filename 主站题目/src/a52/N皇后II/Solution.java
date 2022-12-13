package a52.N皇后II;

/**
 *
 * 皇后不允许处在同一排，同一列，也不允许处在与棋盘边框成45度角的斜线上
 *
 * 尝试回溯法，剪枝
 * 1 <= n <= 9 可以状态压缩
 *
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 * 0 0 0 0
 *
 * 3 2 1 0
 *
 * 0&1 0
 * 1&1 1
 *
 * 8 4 2 1
 *
 * 如何表示两个方向的斜线呢？
 *
 * 方向一的斜线为从左上到右下方向，同一条斜线上的每个位置满足行下标与列下标之差相等，
 * 例如 (0,0)(0,0)(0,0) 和 (3,3)(3,3)(3,3) 在同一条方向一的斜线上。
 * 因此使用行下标与列下标之差即可明确表示每一条方向一的斜线。
 *
 * 时间：O(n*n!)6*4*3 * 往前判断是否符合冲突
 *
 * 可以考虑优化冲突判断
 *
 */
class Solution {
    public int totalNQueens(int n) {
        int[] arr = new int[n];
        dfs(arr,0); // 第一个皇后开始
        return res;
    }
    int res=0;

    /**
     *
     * @param arr
     * @param x 第几个皇后 0-3
     */
    void dfs(int[] arr,int x){
        if(x==arr.length){
            res++;
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(check(arr,x,i)){
                arr[x]=1<<i;
                dfs(arr, x+1);
                arr[x]=0;
            }
        }
    }

    /**
     *
     * @param arr
     * @param x 第几个皇后，0-3
     * @param chose 选择的下标，0-3
     * @return
     */
    private boolean check(int[] arr, int x,int chose) {
        for (int i = 0; i <x ; i++) { // 往上判断
            if((arr[x-i-1]&1<<chose)>0){
                return false; // 同列冲突
            }
            if(chose+i+1<arr.length&&(arr[x-i-1]&1<<(chose+i+1))>0){
                return false; // 左斜上角
            }
            if(chose-i-1>=0&&(arr[x-i-1]&1<<(chose-i-1))>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().totalNQueens(4));
//        System.out.println(new Solution().check(new int[]{8,8,8,0},3,3));
//        System.out.println(new Solution().check(new int[]{4,1,0,0},2,1));
    }
}