package a347.前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 堆
 * map存出现次数，heap维护topk
 * 时间：O(nlogk),遍历数组n,维护堆需要logk
 * 空间：O(n)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurrences=new HashMap<>();
        PriorityQueue<int[]> priorityQueue =new PriorityQueue<>((a,b)->a[1]-b[1]); // PriorityQueue默认小根堆
        for (int num : nums) {
            occurrences.put(num,occurrences.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int key = entry.getKey(),value=entry.getValue();
            if(priorityQueue.size()==k){
                if(priorityQueue.peek()[1]<value){ // 维护堆需要logk
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{key,value});
                }
            }else {
                priorityQueue.offer(new int[]{key,value});
            }
        }
        int[] ans=new int[k];
        for (int i = 0; i <k ; i++) {
            ans[i]=priorityQueue.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2));

    }
}