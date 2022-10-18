package a300.最长递增子序列;

/**
 * 设计思路：
 *
 * 新的状态定义：
 * 我们考虑维护一个列表 tails，其中每个元素 tails[k] 的值代表 长度为 k+1 的子序列尾部元素的值。
 * 如 [1,4,6][1,4,6] 序列，长度为 1,2,3 的子序列尾部元素值分别为 tails = [1,4,6]。
 * 状态转移设计：
 * 设常量数字 N，和随机数字 x，我们可以容易推出：当 N 越小时，N<x的几率越大。例如： N=0 肯定比 N=1000 更可能满足 N<x。
 * 在遍历计算每个 tails[k]，不断更新长度为 [1,k]的子序列尾部元素值，始终保持每个尾部元素值最小
 * （例如 [1,5,3]， 遍历到元素 5 时，长度为 2 的子序列尾部元素值为 5；
 * 当遍历到元素 3 时，尾部元素值应更新至 3，因为 3 遇到比它大的数字的几率更大）。
 */
class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int ans=0;
        int[] tails=new int[nums.length];
        for (int num:nums) {
            int i=0,j=ans;
            // 二分找到最后一个小于当前元素的递增下标
            while (i<j){
                int t=(i+j)/2;
                if(tails[t]<num){
                    i=t+1;
                }else {
                    j=t;
                }
            }
            // 让长度为i的递增序列最后一个元素尽可能小，那么才会越接近最终的结果
            tails[i]=num;
            if(ans==j)ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums={10,9,2,5,3,7,21,18};
        System.out.println(solution2.lengthOfLIS(nums));
    }
}