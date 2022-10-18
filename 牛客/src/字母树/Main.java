package 字母树;

import java.util.*;

/**
 * 给定一棵有n个节点的树，节点用1,2,…n编号。1号节点为树的根节点，每个节点上有一个用大写字母表示的标记。求每个
 * 节点的子树中出现的字母标记种类数。
 * 注：子树的定义：设T是有根树，a是T中的一个顶点，由a以及a的所有后裔（后代）导出的子图称为有根树T的子树。
 * 输入描述
 * 第一行输入一个正整数n，表示树的节点数量。
 * 第二行输入n-1个正整数，第i个整数表示第i+1号节点的父亲节点。
 * 第三行输入长度为n的由大写字母组成的字符串s1s2s3...sn，第i个字符si表示第i号节点的标记。
 * 3≤n≤50000.
 * 数据保证形成一棵合法的树，字符串由大写字母组成。
 * 输出描述
 * 输出n个整数，相邻两个数之间用空格隔开，第i个整数表示第i号节点的子树中出现不同的字母种类数。
 *
 * input:
 * 6
 * 1 2 2 1 4
 * ABCCAD
 *
 * output:
 * 4 3 1 2 1 1
 *
 */

/**
 * 部分用例
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>(); // 父节点值 子节点列表
        int[] keys = new int[n];

        for (int i = 1; i < n; i++) {
            int cur = sc.nextInt();
            List<Integer> list = map.getOrDefault(cur, new LinkedList<>());
            list.add(i + 1);
            map.put(cur, list);
        }
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();
        Map<Character, Integer> map_count = new HashMap<>();
        int[] ans = new int[n];

        for (char aChar : chars) {
            map_count.put(aChar, map_count.getOrDefault(aChar, 0));
        }
        ans[0] = map_count.size();
//        if (map_count.get(chars[0]) > 1) { // 移除跟结点
//            map_count.put(chars[0], map_count.get(chars[0]) - 1);
//        } else {
//            map_count.remove(chars[0]);
//        }

//        int idx = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey(); // 当前结点
            List<Integer> list = entry.getValue(); // 子节点
            Set<Character> set = new HashSet<>();

            set.add(chars[key - 1]);
            ans[key-1] = count(list, chars, map, set);
//            if (!list.isEmpty()) {
//                for (Integer integer : list) {
//                    set.add(chars[integer - 1]);
//                }
//            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==0){
                ans[i]=1;
            }
            System.out.print(ans[i]+" ");

        }
    }

    static int count(List<Integer> list, char[] chars, Map<Integer, List<Integer>> map, Set<Character> set) {
        if (list == null || list.isEmpty()) {
            return set.size();
        }
//         = new HashSet<>();
//        int ans = 0;
//        set.add(chars[key - 1]);
        for (Integer integer : list) {
            set.add(chars[integer - 1]);
            count(map.get(integer), chars, map, set); //递归
        }
//        ans += set.size();
        return set.size();
    }
}
