package a207.课程表;

import java.util.*;

/**
 * 统计课程安排图中每个节点的入度，生成入度表 penetration[]。
 * 生成邻接表 adjacency List<List<>>
 * 借助一个队列 queue，将所有入度为 0 的节点入队。
 *
 * 当队列不为空的时候，出队，并把该结点的临界结点的入度减一，出度如果为0也要入队
 * 最终如果没有有向环，那么每个结点都会入队出队一次，判断最终的numCourses==0
 *
 * 时间：O（v+e） 遍历图需要访问所有结点v和临边e
 * 空间：O（v+e）
 */
class Solution {
    // numCourses从[0,numCourses-1]排列
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] penetration = new int[numCourses];// 入度表
        List<List<Integer>> adjacency = new ArrayList<>();// 邻接表
        Deque<Integer> queue = new LinkedList<>();// 队列：保存入读为0的结点 如果不存在有向环，那么所有结点都会进出队列一次

        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>()); // 初始化邻接表
        }

        for (int i = 0; i < prerequisites.length; i++) {
            penetration[prerequisites[i][1]]++; // 对于结点入度加一
            adjacency.get(prerequisites[i][0]).add(prerequisites[i][1]); // 添加临界结点
        }
        for (int i = 0; i < penetration.length; i++) {
            if (penetration[i] == 0)
                queue.offer(i); // 入读为0的入队
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--; // 每个节点都会出队一次
            List<Integer> adjacencyNode = adjacency.get(poll); // 获取所有的邻接点
            for (Integer integer : adjacencyNode) {
                penetration[integer]--; // 邻接结点入读减一
                if (penetration[integer] == 0)
                    queue.offer(integer); // 入读为0要入队
            }
        }
        return numCourses==0;
    }
}