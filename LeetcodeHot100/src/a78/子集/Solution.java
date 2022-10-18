package a78.子集;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums,new ArrayList<>());
        return lists;
    }

    List<List<Integer>> lists = new ArrayList<>();

    void dfs(int cur, int[] nums, List<Integer> list) {
        lists.add(new ArrayList<Integer>(list));
        if (cur >= nums.length) return; // 这句也得在下面，不然遗漏最后一个子集
        for (int i = cur; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}