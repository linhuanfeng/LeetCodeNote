package 剑指Offer61.扑克牌中的顺子;

class Solution {
    public boolean isStraight(int[] nums) {
        // 我先尝试快排，然后再用0去补
        quickSort(nums,0,nums.length-1);
        int count0=0,distance=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==0){
                count0++;
                continue;
            }
            int t=nums[i+1]-nums[i];
            if(t==0){
                return false;
            }else if(t>1){
                // 可用0去补
                distance+=t-1;
            }
        }
        return distance<=count0;
    }
    void quickSort(int[] num,int left,int right){
        //找一个基准值，我就按第一个
        int key=num[left],i=left,j=right;
        while (i<j){
            while (i<j&&num[j]>key){
                j--;
            }
            if(i<j){
                // 找到了第一个大于key的
                num[i]=num[j];
                i++;
            }
            while (i<j&&num[i]<key){
                i++;
            }
            if(i<j){
                num[j]=num[i];
                j--;
            }
        }
        // i肯定等于j
        num[i]=key;
        if(left<i-1){
            quickSort(num,left,i-1);
        }
        if(i+1<right){
            quickSort(num,i+1,right);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums={0,0,1,5,2};
        System.out.println(solution.isStraight(nums));
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}