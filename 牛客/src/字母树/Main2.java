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
 * 使用使用线序遍历，把结果汇聚到父节点即可，可使用26位进行状态压缩
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ans=new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>(); // 存储树的结构,父节点值 子节点列表
        int root=-1; // 树的根结点

        for (int i = 1; i < n; i++) {
            int cur = sc.nextInt();
            if(i==1){
                root=cur;
            }
            List<Integer> list = map.getOrDefault(cur, new LinkedList<>());
            list.add(i + 1);
            map.put(cur, list);
        }
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();

        inSort(map,root,chars);

        for (int i = 0; i < ans.length; i++) {
            if(ans[i]==0){
                ans[i]=1;
            }
            System.out.print(ans[i]+" ");

        }
    }
    static int[] ans;

    /**
     * 统计当前结点的字母种类
     * 中序遍历，使用位运算存储状态信息
     * @param map 树结构
     * @param root 根节点
     * @param chars 序号对应的字母种类
     * @return 当前结点的字母种类
     */
    static int inSort(Map<Integer, List<Integer>> map,int root,char[] chars){
        if(root==0){
            return 0;
        }
        int count=0|1<<(chars[root-1]-'A'); // 标记种类
        List<Integer> list = map.get(root);

        if(list!=null&&list.size()>=1){
            count|=(inSort(map, list.get(0), chars));
        }
        if(list!=null&&list.size()>=2){
            count|=(inSort(map, list.get(1), chars));
        }

        ans[root-1]=countOne(count);
        return count;
    }

    static int countOne(int i){
        int cnt=0;
        while (i!=0){
            if((i&1)==1){
                cnt++;
            }
            i=i>>1;
        }
        return cnt;
    }
}
