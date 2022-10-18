package 剑指Offer45.把数组排成最小的数;

/**
 * /**
 * 给定一组非负整数 nums，重新排列每个数的顺序 （每个数不可拆分）使之组成一个最大的整数。
 * 输入：nums = [3,30,34,5,9] 输出：""9534330""
 * 快排,使用3+30和30+3拼接比较屏蔽了3和30的细节判断。比如31要排在3前面，3却要排在30前面
 */
public class Solution2 {
    public String minNumber(int[] nums) {
        quickSort(nums,0,nums.length-1);
        StringBuilder builder = new StringBuilder();
        for (int num : nums) {
            builder.append(num);
        }
        return builder.toString();
    }
    public void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i=left,j=right,temp=nums[left];
        while (i<j){
            while ((nums[j]+""+temp).compareTo(temp+""+nums[j])>=0&&i<j){
                j--;
            }
            nums[i]=nums[j];
            while ((nums[i]+""+temp).compareTo(temp+""+nums[j])<=0&&i<j){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=temp;
        quickSort(nums, left,i-1);
        quickSort(nums, i+1,right);
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] arr={3,30,2};
        System.out.println(solution.minNumber(arr));
    }
}
