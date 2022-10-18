package 老张修路_最小生成树;

import java.io.*;
/**
 * 老张在一家工程公司担任规划师。一天，这个工程公司接到了市政府的道路翻新任务，需要在已有的路网上规划一些路段进行翻新，并保证规划中的翻新道路经过了所给路网上所有的结点（一段翻新道路经过其两端的结点），同时所有翻新的路段必须构成一棵树，也就是说不可以存在一段不与其他翻新路段相连的翻新路段。因为翻新成本与道路长度有关，所以需要规划翻新的道路长度和最小，老张想请你帮忙计算这个最小长度和。
 *
 *
 *
 * 输入描述
 * 第一行有2个正整数n和m，表示所给路网的结点数和道路数。
 *
 * 接下来有3行，每一行有m个正整数，每行分别对应ui、vi、wi。
 *
 * 相同位置的一组<ui, vi, wi>表示结点ui和vi之间有一条长度为wi的道路。
 *
 * 输入中的数字，两两间均有空格隔开
 *
 * 1 ≤ ui, vi ≤ n，0 ≤ wi ≤ 1000，1 ≤ m ≤min{30000, n2}。
 *
 * 输出描述
 * 输出1行，只包括1个整数，表示题目所求的最小长度和。
 *
 *
 * 样例输入
 * 3 3
 * 1 1 2
 * 2 3 3
 * 885 513 817
 * 样例输出
 * 1330
 */

/**
 * 最小生成树之Prim算法
 * 使用数组lowCost表示距联通集中的最短距离，初始为到顶点0的距离；之后每加入一个顶点，更新数组
 * 使用数组vertex距联通集的最短距离对应的顶点存储距离已有生成树中距离，
 *
 * 时间：O（n^2）
 * 空间：O(n) 存储 距联通集中的最短距离 和 距联通集的最短距离对应的顶点
 */
// 100
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n=Integer.valueOf(split[0]); // 节点数
        int m=Integer.valueOf(split[1]); // 道路数

        int[][] dist=new int[n][n]; // 邻接表

        String[] split1 = br.readLine().split(" ");
        String[] split2 = br.readLine().split(" ");
        String[] split3 = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            dist[Integer.valueOf(split1[i])-1][Integer.valueOf(split2[i])-1]=Integer.valueOf(split3[i]);
            dist[Integer.valueOf(split2[i])-1][Integer.valueOf(split1[i])-1]=Integer.valueOf(split3[i]);
        }

        int ans=buildMinSpan_tree(dist,n);

        bw.write(String.valueOf(ans));
        bw.flush();
    }
    // prim算法
    private static int buildMinSpan_tree(int[][] dist, int n) {
        // 开始构造最小生成树
        int ans=0;
        int[] lowCost=new int[n], // 距联通集中的最短距离
                vertex=new int[n]; // 距联通集的最短距离对应的顶点

        // 首先把0加入联通集中（最小生成树从哪一个顶点开始结果是一样的）
        lowCost[0]=0;
        vertex[0]=0;
        for (int i = 1; i < n; i++) {
            lowCost[i]=dist[0][i]; // 初始化结点到联通集的距离为到顶点0的距离（lowCost=0表示已加入联通集）
            vertex[i]=0; // 相关顶点左边也为0
        }

        for (int i = 1; i < n; i++) {
            // 找到距离联通集最近的结点
            int k=-1,minValue=Integer.MAX_VALUE;
            // 遍历distance,找到最近的结点
            for (int j = 1; j < n; j++) {
                if(lowCost[j]!=0&&lowCost[j]<minValue){ // 未加入联通集，得到距离当前联通集最近的顶点
                    k=j; // 记录新加入的下标
                    minValue=lowCost[j]; // 更新最小值
                }
            }

            ans+=lowCost[k]; // 累计生成树的花费
            lowCost[k]=0; // 加入联通集

            // 更新distance数组，即到联通集的最短距离
            for (int j = 1; j < n; j++) {
                if(dist[k][j]<lowCost[j]){
                    // 新加入的顶点更近
                    vertex[j]=k;
                    lowCost[j]=dist[k][j];
                }
            }
        }
        return ans;
    }
}
