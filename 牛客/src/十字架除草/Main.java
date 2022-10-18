package 十字架除草;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        int operationCount = in.nextInt();
        int[][] operations = new int[operationCount][4];
        for (int i = 0; i < operationCount; i++) {
            for (int j = 0; j < 4; j++) {
                operations[i][j] = in.nextInt();
            }
        }
        long res = fun(matrix, operations);
        System.out.println(res);
    }

    private static final int[][] DIRS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static long fun(int[][] matrix, int[][] operations) {
        long res = 0;
        for (int[] operation : operations) {
            int time = operation[0];
            int x = operation[1] - 1;
            int y = operation[2] - 1;
            int height = operation[3];
            if (!isValid(matrix, x, y)) {
                continue;
            }
            // 先除自身
            int curHeight1 = (time - 1) + matrix[x][y];
            int heightLost1 = Math.min(curHeight1, height);
            matrix[x][y] -= heightLost1;
            res += heightLost1;
            // 遍历每一个位置
            for (int[] dir : DIRS) {
                for (int i = 1; i <= 2; i++) {
                    int mx = x + i * dir[0];
                    int my = y + i * dir[1];
                    if (!isValid(matrix, mx, my)) {
                        continue;
                    }
                    // 当前位置目前草的高度
                    int curHeight = (time - 1) + matrix[mx][my];
                    // 可以割掉的草的高度
                    int heightLost = Math.min(curHeight, height);
                    // 剩余的高度
                    matrix[mx][my] -= heightLost;
                    res += heightLost;
                }
            }
        }
        return res;
    }

    private static boolean isValid(int[][] matrix, int x, int y) {
        int n = matrix.length;
        int m = matrix[0].length;
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
