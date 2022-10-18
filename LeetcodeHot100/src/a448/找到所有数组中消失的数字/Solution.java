package a448.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] vis=new boolean[nums.length];
        for (int num : nums) {
            vis[num-1]=true;
        }
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(!vis[i])
                ans.add(i+1);
        }
        return ans;
    }
}