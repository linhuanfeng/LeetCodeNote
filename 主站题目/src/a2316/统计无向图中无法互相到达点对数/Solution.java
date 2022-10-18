package a2316.统计无向图中无法互相到达点对数;

import java.util.HashMap;
import java.util.Map;

/**
 * 将所有结点构建并查集
 */
class Solution {
    public long countPairs(int n, int[][] edges) {
        // 将同个根的结点合并一起,统计每个联通集的个数
        Map<Integer,Integer> map=new HashMap<>();
        UnionFind unionFind = new UnionFind(n,map);
        for (int i = 0; i < edges.length; i++) {
            unionFind.union(edges[i][0],edges[i][1]); // 根据边将结点合并
        }
        long ans=0;
        for (Integer count : map.values()) { // 每个连通块的结点数目相乘就是所有未联通的点对
            ans+=(long)count*(n-count); // 防止越界
        }
        return ans/2; // 每个联通块之间计数重复计算了，减去一半
    }
    class UnionFind{
        int[] parent;
        Map<Integer,Integer> map; // 每个根节点对应的并集元素个数，防止之后再从新查找每一个根元素

        public UnionFind(int n,Map<Integer,Integer> map) {
            this.parent =new int[n];
            this.map=map;
            for (int i = 0; i < n; i++) { // 初始化自己为自己的根
                parent[i]=i; // 初始只有自己一个元素
                map.put(i,1);
            }
        }
        // 合并的时候同时记录连通块的长度，减少时间复杂度
        void union(int i,int j) {
            int fi = find(i), fj = find(j);
            if (fi != fj) {
                parent[fi] = fj; // 将i的老大指向j的老大，实现并集的合并
                map.put(fj, map.get(fj) + map.get(fi)); // 根为fi的元素全部给到根fj
                map.remove(fi); // 移除fi为根的元素计数
            }
        }
        int find(int i){
            if(parent[i]!=i){
                return find(parent[i]);
            }
            return i; // 老大是自己说明找到根节点了
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4},{1,6},{5,4}}));
    }
}