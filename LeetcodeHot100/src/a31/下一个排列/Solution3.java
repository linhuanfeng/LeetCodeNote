package a31.下一个排列;


/**
 * 123 132 213 231 321
 *
 * 算法思想：
 *  找到左边较小的数和右边较大的数进行交换，能使结果变大
 *  同时较小的数尽可能大，较大的数尽可能小，两个数都要尽可能靠右，确保是下一个排列
 *
 * 实现：
 *  从右向左找到第一个顺序对【i,i+1】满足nums[i]<nus[i+1]（保证了i+1,n是递减的）,=》较小的数尽可能靠右
 *  然后从[i+1,n]中找到第一个大于nums[i]的数j=>保证较大的数尽可能小和靠右
 *  i和j交换，【i+1,n】反转即可
 *
 * 时间：O（n）
 * 空间：O（1）
 */
public class Solution3 {
    public void nextPermutation(int[] nums) {
        int i;
        // 从右向左找到第一个顺序对【i,i+1】满足nums[i]<nus[i+1]（保证了i+1,n是递减的）,=》较小的数尽可能靠右
        for (i = nums.length-2; i >=0 ; i--) {
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        if(i<0){
            // 没有顺序对，说明已是最大逆序对
            reverse(nums,0, nums.length-1);
        }
        int j;
        // 然后从[i+1,n]中找到第一个大于nums[i]的数j=>保证较大的数尽可能小和靠右
        for (j = nums.length-1; j >=i+1 ; j--) {
            if(nums[j]>nums[i]){
                break;
            }
        }
        // i和j交换，【i+1,n】反转即可
        swap(nums,i,j);
        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        new Solution3().nextPermutation(nums);
    }
}
