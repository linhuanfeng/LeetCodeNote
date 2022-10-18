package 找赝品;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小红拿到了n个物品，每个物品的品质为ai。这n个物品中至少有一个真品。
 * 已知所有真品的品质都是相同的，但赝品的品质比真品低。小红想知道，这n个物品中最多有多少赝品。
 * 输入描述：
 * 第一行输入一个正整数n，代表小红拿到的物品数量。
 * 第二行输入n个正整数ai，代表每个物品的品质。
 * n≤1e5, ai ≤ 1e9
 * 输出描述：
 * 一个整数，代表赝品的数量。
 *
 * input:
 * 1
 * 5
 *
 * output:
 * 0
 *
 * 只有一个物品，显然是真品
 */
// 部分
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt(),max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cur=sc.nextInt();
            Integer aDefault = map.getOrDefault(cur, 0);
            aDefault++;
            map.put(cur, aDefault);
            max=Math.max(max,cur);
        }
        System.out.println(n-map.get(max));
    }
}
