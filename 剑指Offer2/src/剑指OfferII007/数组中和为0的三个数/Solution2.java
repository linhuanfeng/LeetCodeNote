package 剑指OfferII007.数组中和为0的三个数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 先排序，然后先固定一个数，再双指针。能把复杂度降到O(n^2)
 * 去重细节，先排序
 */
class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        Arrays.sort(nums); // 先排序
        for (int i = 0; i <=nums.length-3 ; i++) {
            if(i>0&&nums[i]==nums[i-1])continue; // 去重的关键，和前面相同证明该序列已被取过，再取就重复了
            if(nums[i]>0)continue; // 因为后面的数大于等于当前数，不可能再相加等于0
            // 双指针
            int two=i+1,three=nums.length-1;
            while (two<three){
                int total=nums[i]+nums[two]+nums[three];
                if(total==0){
                    list.add(Arrays.asList(nums[i],nums[two],nums[three]));
                    while (two<three&&nums[three]==nums[--three]);// -2,0,0,2,2 倒数第二个2再取就重复了
                    while (two<three&&nums[two]==nums[++two]);// 同理
                }else if(total>0){ // 右指针左移
                    three--;
                }else {
                    two++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={-2,0,0,2,2};
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}