package a1584.连接所有点的最小费用;

/**
 * 时间：O(n^2)
 * 空间：O(n)
 */
class Solution2 {
    public int minCostConnectPoints(int[][] points) {
        // 我先转为邻接矩阵
        int n=points.length; // 顶点个数
        int[][] dist=new int[n][n];
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int t=Math.abs(points[i][0]-points[j][0])+
                        Math.abs(points[i][1]-points[j][1]);
                dist[i][j]=dist[j][i]=t;
            }
        }
        return buildMinSpan_tree(dist,n);
    }

    /**
     * kruskal算法
     * 时间：O(eloge)
     * 空间：O(n)
     */
    private int buildMinSpan_tree(int[][] dist, int n) {
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