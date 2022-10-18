package 黄金瞳_完全背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小庄在一次机缘巧合的机会，眼睛获取了黄金瞳，黄金瞳的功能是可以看到m种物品10天以后的价格。但是这些物品属于限购物资，最多只能购买一定的数量。现在小庄有资金x可以投资这些物品，如何操作才能实现10天后资产价值最大。
 * <p>
 * 输入描述:
 * 第一行 当前资金 x
 * 第二行物品种类m
 * 第三行每种物品限购数量，m个数字
 * 第四行物品当前价格，m个数字
 * 第五行物品10天后价格，m个数字
 * <p>
 * <p>
 * 输出描述:
 * 10天后资产价值最大值
 * 示例1
 * 输入
 * 11
 * 2
 * 6 5
 * 3 2
 * 5 3
 * 输出
 * 18
 * 说明
 * 第一种物品买3个，第二种物品买1个，初期资产3*3+2*1=11，10天后资产价值最大5*3+3*1=18
 * <p>
 * 01背包问题： dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w]+v) 不取或取，不取背包容量不变，价值等于前一个；取，容量减w,价值加v
 * 每种物品可以无限取
 * 完全背包问题:dp[i][j]=Math.max(dp[i-1][j],dp[i][j-w]+v) 详见https://wenku.baidu.com/view/d024eec9132de2bd960590c69ec3d5bbfd0ada66.html
 * <p>
 * 因为每种物品的数量是有限的，那么我们把完全背包问题转为01背包问题。
 * 比如p1限购2件，p2限购3件，那么存入一个数组为p1,p1,p2,p2,p2
 *
 */
public class Main {
    static class Item { // 也得为静态？
        public int weight;
        public int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int x = sc.nextInt(), // 当前资金
                m = sc.nextInt(); // 物品种类
        int[] limit = new int[m], todayPrice = new int[m], tenPrice = new int[m];
        for (int i = 0; i < m; i++) {
            limit[i] = sc.nextInt(); // 每种商品的限额
        }
        for (int i = 0; i < m; i++) {
            todayPrice[i] = sc.nextInt(); // 花费多少空间weight
        }
        for (int i = 0; i < m; i++) {
            tenPrice[i] = sc.nextInt(); // 带来的价值value
        }

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= limit[i]; j++) {
                list.add(new Item(todayPrice[i], tenPrice[i])); // 转为01背包问题
            }
        }

        final int n = list.size();
        final int[][] dp = new int[n + 1][x + 1]; // 表示前i件物品，背包容量为j，能得到的最大价值

        for (int i = 1; i <= x; i++) { // 初始化，前0件商品，背包价钱为j的最大价值即为j,即不买任何东西原来的钱也算作钱
            dp[0][i]=i;
        }

        for (int i = 1; i <= n; i++) {
            Item item = list.get(i - 1); // 每一种物品
            for (int j = 1; j <= x; j++) { // 背包容量
                if (j < item.weight) {
                    dp[i][j] = dp[i - 1][j]; // 装不下，等于前i-1件的价值
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.weight] + item.value);
                }
            }
        }

        // 注意如果还有剩下的钱，那么还要加上
        // 从后往前递归查找哪些物品被取了：如果dp[i][j]>dp[i-1][j]说明取了，那么前一件放进去时的容量为dp[i-1][j-w[i]]
//        int ans = dp[n][x] + x;
//        for (int i = n, j = x; i > 0; i--) {
//            if (dp[i][j] > dp[i - 1][j]) { // 说明拿了
//                int weight = list.get(i - 1).weight;
//                ans -=weight;
//                j-=weight; // 跳转到到i-1放入时的背包容量
//            }
//        }

//        System.out.println(ans);
        System.out.println(dp[n][x]);
        sc.close();
    }
}

//#include<iostream>
//#include<vector>
//using namespace std;
//
//        int main() {
//        int bagSize;
//        cin>>bagSize; 背包大小
//        int num;
//        cin>>num; 物品种类数目
//        vector<int> nums(num);
//        for (int i = 0; i < num; ++i) {
//        cin>>nums[i]; 限购数量
//        }
//        vector<int> weights(num);
//        for (int i = 0; i < num; ++i) {
//        cin>>weights[i]; 消耗的空间
//        }
//        vector<int> values(num);
//        for (int i = 0; i < num; ++i) {
//        cin>>values[i]; 价值
//        }
//        for (int i = 0; i < num; ++i) {
//        int count = nums[i];
//        while (count > 1) {
//        weights.emplace_back(weights[i]);
//        values.emplace_back(values[i]);
//        --count;
//        }
//        }
//        vector<int> dp(bagSize + 1, 0);
//        for (int i = 0; i < weights.size(); ++i) {
//        for (int j = bagSize; j >= weights[i]; --j) {
//        dp[j] = max(dp[j], dp[j - weights[i]] + values[i]);
//        }
//        }
////    for (auto& w : weights) cout << w << ' ';
////    cout << endl;
////    for (auto& v : values) cout << v << ' ';
////    cout << endl;
//        int i = bagSize;
//        while (i > 0 && dp[i] == dp[i - 1]) {
//        --i;
//        }
//        int res = dp[i] + bagSize - i;
//        cout << res << endl;
//        return 0;
//        }
