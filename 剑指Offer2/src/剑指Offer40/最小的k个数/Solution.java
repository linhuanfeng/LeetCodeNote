package 剑指Offer40.最小的k个数;

/**
 * 手写堆排序
 *      时间复杂度：logn
 *      空间复杂度：存放结果的res[k]
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 1.构建大根堆，从第一个非叶子节点开始
        for (int i=arr.length/2-1 ; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        int[] res=new int[k];
        // 2. 把最大值和最后一个元素交换
        for (int i = arr.length-1; i >=arr.length-k ; i--) {
            swap(arr,0,i);
            res[arr.length-i-1]=arr[i];
            adjustHeap(arr,0,i);
        }
        return res;
    }

    // 调整子堆
    private void adjustHeap(int[] nums,int k,int len){
        int temp=nums[k];
        for (int i = 2*k+1; i <len ; i=i*2+1) {
            if(i+1<len&&nums[i+1]<nums[i]){
                // 找到较大的子节点
                i++;
            }
            // 找到最后一个大的节点
            if(nums[i]<temp){
                // 把值赋给父节点，不用交换
                nums[k]=nums[i];
                k=i;
            }else {
                break;
            }
        }
        nums[k]=temp; //放到最终的位置
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={3,2,1};
        Solution solution = new Solution();
        for (int item : solution.getLeastNumbers(arr, 2)) {
            System.out.print(item+" ");
        }
    }
}
