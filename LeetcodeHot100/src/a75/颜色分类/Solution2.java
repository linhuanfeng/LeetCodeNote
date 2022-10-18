package a75.颜色分类;

/**
 * 快排分区思想：小于key,等于key,大于key 由于当前只有三种元素，那么分区不用再递归进行
 * 循环不变量：分区不变性
 *
 */
class Solution2 {
    public void sortColors(int[] nums) {
        int len=nums.length;
        if(len<2)return;
        /**
         * all in [0,阿里.p1)     等于0
         * all in [阿里.p1,阿里.p2)    等于1
         * all in [阿里.p2,len-1] 等于2
         */
        int i=0,p1=0,p2=len; // i当前数
        while (i<p2){
            if(nums[i]==2){
                p2--;
                swap(nums,i,p2);
            }else if(nums[i]==1){
                i++;
            }else { // ==0
                swap(nums,p1,i);
                p1++;
                i++; // 因为前面的数已经遍历过了，一定符合条件
            }
        }
    }
    void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums={2,0,2,1,1,0};
        solution.sortColors(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}