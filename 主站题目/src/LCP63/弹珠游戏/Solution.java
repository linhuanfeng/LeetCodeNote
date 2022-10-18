package LCP63.弹珠游戏;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] ballGame(int num, String[] plate) {
        List<int[]> list = new ArrayList<>();
        int row = plate.length, col = plate[0].length();
        for (int j = 1; j < col - 1; j++) {
            if (plate[0].charAt(j)=='.'&&check(plate, 0, j, 2, num)) { // 注意仅能在空白取余进入
                list.add(new int[]{0, j});
            }
            if (plate[row-1].charAt(j)=='.'&&check(plate, row - 1, j, 0, num)) {
                list.add(new int[]{row - 1, j});
            }
        }

        for (int i = 1; i < row - 1; i++) {
            if (plate[i].charAt(0)=='.'&&check(plate, i, 0, 1, num)) {
                list.add(new int[]{i, 0});
            }
            if (plate[i].charAt(col-1)=='.'&&check(plate, i, col - 1, 3, num)) {
                list.add(new int[]{i, col - 1});
            }
        }
        return list.toArray(new int[0][0]);
    }
    /*
     0上 1右 2下 3左

     0上遇到w变成向左3，遇到E变成向右1，否则不变
     1右遇到w变成向上0，遇到E变成向下2
     2下遇到w变成向右1，遇到E变成向左3
     3左遇到w变成向下2，遇到E变成向上0

     dx[0,1,2,3]={-1,0,1,0};
     dy[0,1,2,3]={0,1,0,-1};
     */

    /**
     * @param direction 当前方向
     * @return
     */
    int[][] dir = {{3, 1}, {0, 2}, {1, 3}, {2, 0}};
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int nextDirection(int direction, char k) {
        if (k == 'W') {
            return dir[direction][0];
        } else if (k == 'E') {
            return dir[direction][1];
        } else {
            return direction;
        }
    }

    /**
     * @param plate
     * @param i
     * @param j
     * @param direction 当前的方向
     * @return
     */
    boolean check(String[] plate, int i, int j, int direction, int num) {
        if (num < 0) {
            return false;
        }
        if (i < 0 || i == plate.length || j < 0 || j == plate[0].length()) {
            return false;
        }
        if (plate[i].charAt(j) == 'O') {
            return true;
        } else {
            int next = nextDirection(direction, plate[i].charAt(j));
            return check(plate, i + dx[next], j + dy[next], next, num - 1);
        }
    }

    public static void main(String[] args) {
//        String[] arr = new String[]{"E...W..WW",".E...O...","...WO...W","..OWW.O..",".W.WO.W.E","O..O.W...",".OO...W..","..EW.WEE."};
        String[] arr = new String[]{".....","....O","....O","....."};
        int[][] ints = new Solution().ballGame(3, arr);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }
    }
}