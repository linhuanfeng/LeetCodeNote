public class Solution {
    public static void main(String[] args) {
        int[] nums={3,4,2,0,0,1};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(nums));
    }
//    public int findRepeatNumber(int[] nums) {
//        for(int i=0;i<nums.length;i++){
//            int cur=nums[i];
//            if(nums[cur]==cur&&i!=cur){
//                // 原数组上面已经有值匹配，现在又有另一个和它匹配，说明重复了
//                return cur;
//            }else{
//                // 进行交换，即让nums[i]=i
//                nums[i]=nums[cur];
//                nums[cur]=cur;
//            }
//            for (int num : nums) {
//                System.out.print(num);
//            }
//            System.out.println();
//        }
//        return nums[nums.length-1]; // 最后一个值刚好就是重复的值，我也不知道为什么
//    }
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                // 这是和上面的区别，只有当前值和下标相等才会i+1
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
            for (int num : nums) {
                System.out.print(num);
            }
            System.out.println();
        }
        return -1;
    }
}
