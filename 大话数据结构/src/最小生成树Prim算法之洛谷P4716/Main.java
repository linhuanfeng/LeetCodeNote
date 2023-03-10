package 最小生成树Prim算法之洛谷P4716;

import java.util.Scanner;

/**
 * 这是一道模板题。
 *
 * 题目描述
 * 给定包含 nn 个结点， mm 条有向边的一个图。试求一棵以结点 rr 为根的最小树形图，并输出最小树形图每条边的权值之和，如果没有以 rr 为根的最小树形图，输出 -1−1。
 *
 * 输入格式
 * 第一行包含三个整数 n,m,rn,m,r，意义同题目所述。
 *
 * 接下来 mm 行，每行包含三个整数 u,v,wu,v,w，表示图中存在一条从 uu 指向 vv 的权值为 ww 的有向边。
 *
 * 输出格式
 * 如果原图中存在以 rr 为根的最小树形图，就输出最小树形图每条边的权值之和，否则输出 -1−1。
 *
 * 输入输出样例
 * 输入 #1复制
 * 4 6 1
 * 1 2 3
 * 1 3 1
 * 4 1 2
 * 4 2 2
 * 3 2 1
 * 3 4 1
 * 输出 #1复制
 * 3
 */
public class Main {
    // 最外层不存储数据 本身已加一层了  r表示开始的节点
    int MiniSpanTree_Prim(int[][] graph,int r){
        int ans=0;

        int min,i,j,k;
        int relativeVex[]=new int[graph.length]; //相关联的结点：即和已有树哪个结点相连
        int lowCost[]=new int[graph.length]; // 当前结点到生成树的最小代价

        lowCost[r]=0; // 初始化第一个结点r,表示已加入生成树
        relativeVex[r]=r; //初始化相关结点为本身

        // 初始化所有结点到r的距离，即到已有生成树的距离
        for (int l = 1; l < graph.length; l++) {
            if(l==r){
                // 不计算当前节点
                continue;
            }
            lowCost[l]=graph[r][l];
            relativeVex[l]=r;
        }
        for (int l = 1; l <graph.length-1 ; l++) {
            min=Integer.MAX_VALUE;
            j=1;
            k=r; //记录哪个节点可以加入进来
            while (j<graph.length){
                if(lowCost[j]!=0&&lowCost[j]<min){ // 不在已有树中且小于已有权值
                    min=lowCost[j]; // 找到当前生成树到外面的最小权值
                    k=j; // 记录距离已有生成树距离最短的节点
                }
                j++;
            }
            ans+=min; // 增加最小生成树的代价
            lowCost[k]=0; // 加入当前节点
            // 循环所有节点，更新外面节点到树的最小距离
            for (int m = 1; m <graph.length ; m++) {
                if(lowCost[m]!=0&&graph[k][m]<lowCost[m]){
                    lowCost[m]=graph[k][m]; // 更新到最小生成树的距离
                    relativeVex[m]=k; // 离最小生成树最近相关节点
                }
            }
        }
        for (int g=1;g<graph.length;g++){
            if(lowCost[g]!=0){
                return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n,m,r;
        Scanner s = new Scanner(System.in);
        n=s.nextInt(); // n个结点
        m=s.nextInt(); // 接下来m行
        r=s.nextInt(); // 从r结点开始
        int[][] graph=new int[n+1][n+1]; // 用邻接矩阵存储图
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                graph[i][j]=Integer.MAX_VALUE; // 初始化表示不可达
            }
        }
        for (int i = 0; i <m ; i++) {
            graph[s.nextInt()][s.nextInt()]=s.nextInt();
        }

        Main solution = new Main();
        System.out.println(solution.MiniSpanTree_Prim(graph, r));
//        for (int i = 0; i < graph[0].length; i++) {
//            for (int j = 0; j < graph[0].length; j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
}
