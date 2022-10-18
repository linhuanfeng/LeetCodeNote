package 剑指Offer11.旋转数组的最小数字;

public class Solution {
    // 有序应该就可以二分
    public int minArray(int[] numbers) {
        int left=0,right=numbers.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if(numbers[mid]<numbers[right]){
                // 最小的在左边或当前
                right=mid;
            }else if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else{
                // 由于mid和high相等，所以把high舍弃了，至少会有mid来替代它。
                right-=1;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers={3,3,1,3};
        Solution solution = new Solution();
        System.out.println(solution.minArray(numbers));
    }
}
