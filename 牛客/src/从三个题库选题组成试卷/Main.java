package 从三个题库选题组成试卷;

import java.util.Scanner;

/**
 * 3
 * 2 7 2
 * 1 5 3
 * 4 6 3
 * <p>
 * 4
 * <p>
 * 提示
 * 满足条件的4种组合方式：
 * <p>
 * 1.选择题库A的第一题，题库B的第三题，题库C的第一题，三道题的难度依次为2、3、4。
 * <p>
 * 2.选择题库A的第一题，题库B的第三题，题库C的第二题，三道题的难度依次为2、3、6。
 * <p>
 * 3.选择题库A的第三题，题库B的第三题，题库C的第一题，三道题的难度依次为2、3、4。
 * <p>
 * 4.选择题库A的第三题，题库B的第三题，题库C的第二题，三道题的难度依次为2、3、6。
 */
// 9
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], b = new int[n], c = new int[n];
        int[][] arr = new int[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(arr,0,n,new int[3]);
        System.out.println(last);
    }
    static int last=0;

    static void dfs(int[][] arr, int row, int n, int[] ans) {
        if(row==3){
            last++;
            return;
        }
        if (row == 0) {
            for (int i = 0; i < n; i++) {
                ans[row] = arr[row][i];
                dfs(arr, row + 1, n, ans);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (arr[row][i]>ans[row-1]&&arr[row][i] <= ans[row - 1] * 2){
                    ans[row] = arr[row][i];
                    dfs(arr, row + 1, n, ans);
                }
            }
        }
    }
}
