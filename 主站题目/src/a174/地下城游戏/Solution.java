package a174.地下城游戏;

/**
 * 深度搜索（回溯）
 * <p>
 * ①统计每一条路径的最低初始健康生命，②还要累计路径当前生命值（是最低初始生命值的前提）
 * 两个重要程度一样，影响着后面的结果，也就是不满足动态规划的无后效性
 * 使用dungeon保存路径累计生命值，记得回溯的时候恢复原值
 *
 * 时间：O(2^n)
 * 空间：O(n)栈的深度
 */
// 90
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        dfs(dungeon, 0, 0, dungeon[0][0]);
        return targetLife >= 0 ? 1 : (targetLife-1) * -1; // 大于等于0说明初始不用血量
    }

    int targetLife = Integer.MIN_VALUE;

    /**
     * -3 5 2 -30
     * 小于0的才计算最大的
     * <p>
     * 路线path       -3  4  -5
     * 当前生命arr     -3  1  -4
     * 最小生命(只会递减)-3 -3 -4
     *
     * 注意非负：如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
     *
     * @param arr
     * @param x
     * @param y
     * @param minLife 路径最少生命，只减不增
     */
    void dfs(int[][] arr, int x, int y, int minLife) {
        if (minLife <= targetLife) { // 只需要最大的最小的生命，剪枝
            return;
        }
        if (x == arr.length - 1 & y == arr[0].length - 1) { // 到达终点
            targetLife = minLife;
            return;
        }
        // 向下探测
        if (x + 1 < arr.length) {
            int cur = arr[x + 1][y]; // 回溯的时候恢复原值
            arr[x + 1][y] += arr[x][y];
            dfs(arr, x + 1, y, Math.min(minLife, arr[x + 1][y]));
            arr[x + 1][y] = cur;
        }
        // 向右探测
        if (y + 1 < arr[0].length) {
            int cur = arr[x][y + 1];
            arr[x][y + 1] += arr[x][y];
            dfs(arr, x, y + 1, Math.min(minLife, arr[x][y + 1]));
            arr[x][y + 1] = cur;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculateMinimumHP(
                new int[][]{{-2,-3,3},
                        {-5,-10,1},
                        {10,30,-5}}));
    }
}