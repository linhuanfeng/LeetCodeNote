package a34.在排序数组中查找元素的第一个和最后一个位置;


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)return new int[]{-1,-1};
        // 二分找到改位置
        int left = findIndex(nums, target, true);
        if(left==-1){
            return new int[]{-1,-1};
        }else {
            return new int[]{left,findIndex(nums,target,false)};
        }
    }

    /**
     *
     * @param nums
     * @param target
     * @param tag 为true表示左下标，false表示有下标
     * @return
     */
    int findIndex(int[] nums,int target,boolean tag){
        int i=0,j=nums.length-1,ans=-1; // 这个ans很细节，记住前一个相等的即可，防止j=mid或i=mid死循环，让j=mid-1或i=mid+1
        while (i<=j){ // 要等于号，不然下标找不全，且下面==部分已经防止死循环了
            int mid=(i+j)/2; // 要加一 不然死循环
            if(nums[mid]==target){
                ans=mid; // 提前保存target的下标
                if(tag){   // 下面是为了防止死循环，比如2，2 target=2
                    j=mid-1;
                }else {
                    i=mid+1;
                }
            }else if(nums[mid]>target){
                j=mid-1;
            }else {
                i=mid+1;
            }
        }
        return ans!=-1?ans:-1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={5,7,7,8,8,10};
        for (int i : solution.searchRange(nums, 8)) {
            System.out.print(i+" ");
        }
    }
}