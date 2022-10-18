package 剑指OfferII007.数组中和为0的三个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 无法去重的解法
 * 去重细节，先排序，如果
 */
class Solution {
    List<List<Integer>> list=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // 先排序
        dfs(0,nums,new ArrayList<>());
        return list;
    }
    public void dfs(int cur,int[] nums,List<Integer> tmp_list){
        if(tmp_list.size()>=3){
            int total=0;
            for (Integer integer : tmp_list) {
                total+=integer;
            }
            if(total==0)
                list.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int i = cur; i <nums.length ; i++) {
            //
            tmp_list.add(nums[i]);
            dfs(i+1,nums,tmp_list);
            tmp_list.remove(tmp_list.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}