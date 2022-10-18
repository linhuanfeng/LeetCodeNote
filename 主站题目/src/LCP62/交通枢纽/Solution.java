package LCP62.交通枢纽;

import java.util.HashMap;
import java.util.Map;
// 100
class Solution {
    public int transportationHub(int[][] path) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < path.length; i++) {
            // 出度减一
            map.put(path[i][0],map.getOrDefault(path[i][0],0)-1);
            map.put(path[i][1],map.getOrDefault(path[i][1],0)+1);
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            if(integerIntegerEntry.getValue()==map.size()-1){
                return integerIntegerEntry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().transportationHub(new int[][]
                {{0, 1}, {0, 3}, {1, 3}, {2, 0}, {2, 3}}));
    }
}