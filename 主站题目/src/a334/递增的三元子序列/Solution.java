package a334.递增的三元子序列;
/*
赋初始值的时候，已经满足second > first了，现在找第三个数third
(1) 如果third比second大，那就是找到了，直接返回true
(2) 如果third比second小，但是比first大，那就把second指向third，然后继续遍历找third
(3) 如果third比first还小，那就把first指向third，然后继续遍历找third（这样的话first会跑到second的后边，但是不要紧，因为在second的前边，老first还是满足的）
 */
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
